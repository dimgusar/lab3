package org.example.parserManipulatiom;

import org.example.convertFiles.ConvertJson2types;
import org.example.importFile.ImporterBuilder;
import org.example.reactors.Reactor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class ParserManipulation {
    private ImporterBuilder ib = new ImporterBuilder();
    
    public void createFiles() throws IOException {
            ConvertJson2types converter = new ConvertJson2types();
            if (!new File("./Reactors_xml.xml").exists()){
                converter.convert2xml();
            }
            if (!new File("./Reactors_yaml.yaml").exists()){
                converter.convert2yaml();
            }

    }
    public ArrayList<Reactor> importData(String filePath) {
        return ib.getData(filePath);
    }

}
