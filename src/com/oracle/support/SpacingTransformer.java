package com.oracle.support;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import COM.FutureTense.Interfaces.Utilities;
import com.fatwire.transformer.common.TransformerFormat;
import com.fatwire.transformer.tika.DocumentTransformerImpl;

/* 
 * This class uses the superclass to perform the actual transformation
 * which stores its result in a temporary file, all this class does is
 * prepend a single space to the contents of the file so that the first
 * word will get indexed properly
 * 
 * To use this, compile into a jar and place in WEB-INF/lib, and
 * modify transformer-format.xml in WEB-INF/classes to reference this
 * new class.
 * 
 * Logger com.oracle.support.SpacingTransformer can be enabled
 * which will log a single message when the SpacingTransformer is called
 * 
 * This code is just a test, it is not an officially supported solution
 * from Oracle or Oracle Support. 
 * 
 * @author phil.gleghorn@oracle.com
 *
 */
public class SpacingTransformer extends DocumentTransformerImpl {

	public static Log _logger = LogFactory.getLog(SpacingTransformer.class
			.getName());

	@Override
	public String getOutputDocument(String inputfile,
			TransformerFormat outputformat) {
		_logger.info("hello from " + SpacingTransformer.class.getName());
		String outputfile = super.getOutputDocument(inputfile, outputformat);
		String s1 = Utilities.readFile(outputfile, "UTF-8");
		Utilities.writeFile(outputfile, " " + s1);
		return outputfile;
	}

}
