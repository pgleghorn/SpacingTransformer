Lucene transformer that prepends a space to the result, created to workaround an Oracle WebCenter Sites issue. Compiles to spacingtransformer.jar which is added to Sites webapp, and configured in transformer-formats.xml

~~~
    <transformer-options> <!-- number of possible transformer available for this tranformation -->
               <transformer>
                          <name>TIKA</name>
                                  <properties>
                                                <property>
                                                <name>ClassName</name> <!-- name of the transformer class with gets loaded by tranformer factory -->
                                                <!--  <value>com.fatwire.transformer.tika.DocumentTransformerImpl</value> -->
                                                <value>com.oracle.support.SpacingTransformer</value>
                                                </property>
                                                <property>
                                                <name>InputFile_Exts</name> <!-- allowed input file extentions..* means all file types supported by tika -->
                                                <value>*</value>
                                                </property>
                                  </properties>
                    </transformer>
    </transformer-options>
~~~
