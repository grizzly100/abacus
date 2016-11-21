package abacus.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class CmdApplication
{
    private Logger log = LoggerFactory.getLogger(CmdApplication.class);

    private static Injector injector;

    public static void main(String[] args)
    {
        injector = Guice.createInjector(new CmdModule());

        CmdApplication application = injector.getInstance(CmdApplication.class);

        application.start();
    }

    private void start()
    {
        log.info("Welcome!");

        injector.getInstance(CmdInitializer.class);

        // Do Work!
    }
}