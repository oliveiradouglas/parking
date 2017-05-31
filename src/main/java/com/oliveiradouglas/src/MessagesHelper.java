package com.oliveiradouglas.src;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;

public class MessagesHelper {
	private final static String BASE_FILE_NAME = "src/main/resources/messages%s.properties";

	/**
	 * Pega a mensagem tageada pela chave passada por parâmetro, nos arquivos de mensagem com base na localização passada
	 * @param String key
	 * @param Locale locale
	 * @return
	 * @throws IOException
	 */
	public static String getMessage(String key, Locale locale) throws IOException {
		Properties prop        = new Properties();
		InputStream input      = null;
		String searchedMessage = "";
		String messagesFile = findPropertiesFileName(locale);

        try {
			input = new FileInputStream(messagesFile);
			prop.load(input);
			searchedMessage = prop.getProperty(key);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				input.close();
			}
		}
		
		return searchedMessage;
	}

	/**
	 * Devolve o nome do arquivo que contem as mensagens com base na localização
	 * @param java.util.Locale locale
	 * @return
	 */
	private static String findPropertiesFileName(Locale locale) {
		String messagesFile = String.format(BASE_FILE_NAME, "");
		
		if(locale != null) {			
			File f = new File(String.format(BASE_FILE_NAME, "_" + locale.getLanguage() + "_" + locale.getCountry()));
			
			if(f.exists()) { 
				messagesFile = f.getAbsolutePath();
			}
		}
		
		return messagesFile;
	}
}
