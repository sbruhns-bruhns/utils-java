package tech.stefanbruhns.utils.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileUtil {
    
	/**
	 * Read the contents of a text file with the given name and return them as a string.
	 * 
	 * @param fileName
	 * @return
	 * 
	 * @throws FileUtilException
	 */
    public String readTextFile(final String fileName) throws FileUtilException {
        StringBuffer fileContents = new StringBuffer();
        BufferedReader reader = null;
        
        try {
            reader = new BufferedReader(new FileReader(fileName), 8192 * 20);
            
        } catch(FileNotFoundException e) {
            throw new FileUtilException(e.getMessage(), e);
        }

        try {
            String line;

            while ((line = reader.readLine()) != null) {
                fileContents.append(line).append(System.lineSeparator());
            }

        } catch (IOException e) {
            throw new FileUtilException(e.getMessage(), e);
            
        } finally {
            try {
                if (reader != null) reader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        return fileContents.toString();
    }

    /**
     * Write the given String to a file with the given file name.
     * 
     * @param fileName
     * @param fileContents
     * @param doAppend
     * 
     * @throws FileUtilException
     */
    public void writeTextFile(final String fileName, final String fileContents, final boolean doAppend) throws FileUtilException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, doAppend))) {
            writer.write(fileContents);
            writer.flush();
            
        } catch (IOException e) {
            throw new FileUtilException(e.getMessage(), e);
        }
    }
    
    /**
     * Write the content of the given StringBuffer to a file with the given file name.
     * 
     * @param fileName
     * @param fileContents
     * @param doAppend
     * 
     * @throws FileUtilException
     */
    public void writeTextFile(final String fileName, final StringBuffer fileContents, final boolean doAppend) throws FileUtilException {
        writeTextFile(fileName, fileContents.toString(), doAppend);
    }
    
    /**
     * Get a list of files in the given directory.
     * 
     * @param folderName
     * @return
     * 
     * @throws FileUtilException
     */
    public List<File> getFiles(String directory) throws FileUtilException {
    	List<File> files = new ArrayList<File>();

    	try (Stream<Path> paths = Files.walk(Paths.get(directory))) {
    	    paths.filter(Files::isRegularFile).forEach(path -> {
    	        files.add(path.toFile());
    	    });

    	} catch (IOException e) {
    		throw new FileUtilException(e.getMessage(), e);
    	}

    	return files;
    }
}

