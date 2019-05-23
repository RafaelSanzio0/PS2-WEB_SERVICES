package ws;

import dao.CidadeDAO;
import dao.JogoDAO;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class Servidor extends Application<Configuration> {

    public static void main(String args[]) throws Exception {
        Servidor servidor = new Servidor();
        servidor.run(new String[]{"server"});
    }

    @Override
    public void initialize(final Bootstrap<Configuration> bootstrap) {
        //Mapeia a pasta "src/html" para a url "http://localhost:8080/" e
        // por padrao abre o arquivo index.html quando um recurso especifico
        // nao for informado
        bootstrap.addBundle(new AssetsBundle("/front", "/", "index.html"));
    }

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {
        JogoDAO jogoDao = new JogoDAO();
        CidadeDAO cidadeDAO = new CidadeDAO();
        environment.jersey().register(new JogoResource(jogoDao));
        environment.jersey().register(new CidadeResource(cidadeDAO));
        
        // Mapeia todos os WebServices para a rota base 
        // "http://localhost:8080/api/"
        environment.jersey().setUrlPattern("/api/*");
    }

}
