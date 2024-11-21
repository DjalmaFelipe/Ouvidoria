package com.unifacisa.ouvidoria.service;

import weka.classifiers.Classifier;
import weka.classifiers.trees.RandomForest;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.unifacisa.ouvidoria.entity.Usuario;
import com.unifacisa.ouvidoria.repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ChurnService {
	

    private Classifier classifier;
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public ChurnService() {
        try {
            // Carrega o dataset churn.arff
            DataSource source = new DataSource("src/main/resources/churn.arff");
            Instances dataset = source.getDataSet();

            // Define o índice da classe (a última coluna)
            dataset.setClassIndex(dataset.numAttributes() - 1);

            // Inicializa o classificador Random Forest
            classifier = new RandomForest();
            classifier.buildClassifier(dataset);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String preverChurn(String nome) {
    	
    	Usuario usuario = usuarioRepository.findByUsername(nome).orElseThrow(() -> new RuntimeException("usuario nao econtrado"));
    	
    	
        try {
            // Cria o conjunto de atributos para o dataset de teste
            ArrayList<Attribute> attributes = new ArrayList<>();
            attributes.add(new Attribute("idade"));
            attributes.add(new Attribute("tempo_assinatura"));
            attributes.add(new Attribute("satisfacao"));
            attributes.add(new Attribute("interacoes"));
            List<String> churnValues = Arrays.asList("sim", "nao");
            attributes.add(new Attribute("churn", churnValues));

            // Cria uma instância com os atributos passados
            Instances dataset = new Instances("TestInstances", attributes, 0);
            Instance instance = new DenseInstance(4);  // 4 atributos (sem a classe)
            instance.setValue(attributes.get(0), usuario.getAge());
            instance.setValue(attributes.get(1), usuario.getTempoDeCadastro());
            instance.setValue(attributes.get(2), usuario.getMediaAvaliacoes());
            instance.setValue(attributes.get(3), usuario.getInteracoes());
            dataset.add(instance);

            // Define o índice da classe
            dataset.setClassIndex(dataset.numAttributes() - 1);

            // Classifica a instância
            double label = classifier.classifyInstance(dataset.instance(0));
            return dataset.classAttribute().value((int) label);  // Retorna "sim" ou "não"
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao classificar";
        }
    }
}
