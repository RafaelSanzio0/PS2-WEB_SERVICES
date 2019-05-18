package ws;

import dao.CidadeDAO;
import dao.JogoDAO;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;

public class Servidor extends Application<Configuration>{
    
    @Override
    public void run (Configuration configuration, Environment environment) throws Exception{
        JogoDAO jogoDao = new JogoDAO();
        CidadeDAO cidadeDAO = new CidadeDAO();
        environment.jersey().register(new JogoResource(jogoDao));  
        environment.jersey().register(new CidadeResource(cidadeDAO));
    }
    
    public static void main(String args[]) throws Exception{
        Servidor servidor = new Servidor();
        servidor.run(new String[]{"server"});
    }
}
