package ws;


import dao.JogoDAO;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;

public class Servidor extends Application<Configuration>{
    
    @Override
    public void run (Configuration configuration, Environment environment) throws Exception{
        JogoDAO dAO = new JogoDAO();
        environment.jersey().register(new JogoResource(dao));
    }
    
    public static void main(String args[]) throws Exception{
        Servidor servidor = new Servidor();
        servidor.run(new String[]{"server"});
    }
    

}
