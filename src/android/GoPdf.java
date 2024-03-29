/*
 * Author : Manuja Jayawardana
 * Github : https://github.com/jmanuja
 * File Name : GoPdf.java
 * 
 */

package com.cordova.plugin.gopdf;

import java.io.File;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import android.net.Uri;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaResourceApi;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class GoPdf extends CordovaPlugin
{
	private static final String LOG_TAG = "GoPdf";

	public  String fileUrl ;
	Integer pageNumber = 0;
	String pdfFileName;


	/**
	 * Constructor.
	 */
	public GoPdf() {

	}

    @Override
    public boolean execute (String action, JSONArray args, CallbackContext callbackContext) throws JSONException
    {
	
		if( action.equals("read") )
		{
			String fileArg = args.getString(0);
			this._read(fileArg,callbackContext);
            return true;
		}
		return false;
    }

	private void _read(String fileArg, CallbackContext callbackContext) {
		cordova.getThreadPool().execute(new Runnable() {
            public void run() {
                try {
					try {
						CordovaResourceApi resourceApi = webView.getResourceApi();
						Uri fileUri = resourceApi.remapUri(Uri.parse(fileArg));
						fileUrl = fileUri.getPath();
						Log.d(LOG_TAG, "File " + fileArg );
					} catch (Exception e) {
						Log.d(LOG_TAG, "File Not Found " + fileArg );
						fileUrl = fileArg;
					}
					
					Log.d(LOG_TAG, "PDF READ PROCESS STARTED" );
					File storageDir = new File(fileUrl);
					pdfFileName = storageDir.getName();

					String parsedText="";
					PdfReader reader = new PdfReader(storageDir.getAbsolutePath());
					int n = reader.getNumberOfPages();
					for (int i = 0; i <n ; i++) {
						parsedText   = parsedText+ PdfTextExtractor.getTextFromPage(reader, i+1).trim()+"\n"; //Extracting the content from the different pages
					}

					reader.close();

					Log.d(LOG_TAG, "PDF READ PROCESS SUCCESS" );

					JSONObject successObj = new JSONObject();
					successObj.put("status", "Success");
					successObj.put("message", parsedText);					

					callbackContext.success(successObj);

				}catch(Exception e){
					try{
						e.printStackTrace();
						Log.d(LOG_TAG, e.getMessage() );
						JSONObject errorObj = new JSONObject();
						errorObj.put("status", "error");
						errorObj.put("message", e.getMessage());
						callbackContext.error(errorObj);
					}catch (JSONException ex) {
						Log.d(LOG_TAG, ex.getMessage());
					}
				}
            }
        });
	}


}
