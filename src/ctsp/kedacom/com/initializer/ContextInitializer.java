package ctsp.kedacom.com.initializer;

import ctsp.kedacom.com.BasicConfigurator;
import ctsp.kedacom.com.config.Configurator;
import ctsp.kedacom.com.context.LoggerContext;
import ctsp.kedacom.com.util.LoaderUtil;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ServiceLoader;

public class ContextInitializer {

    public final static String CONFIG_FILE_PROPERTY = "logback.configurationFile";
    public final static String AUTOCONFIG_FILE = "logback.xml";

    private final LoggerContext loggerContext;

    public ContextInitializer(LoggerContext loggerContext) {
        this.loggerContext = loggerContext;
    }

    public void autoConfig() {
        URL url = findURLOfDefaultConfigurationFile();
        if (url != null) {
            configureByResource(url);
        } else {
            Configurator config = ServiceLoader.load(Configurator.class).iterator().next();
            if (config != null) {
                config.setContext(loggerContext);
                config.configure(loggerContext);
            } else {
                BasicConfigurator basicConfigurator = new BasicConfigurator();
                basicConfigurator.setContext(loggerContext);
                basicConfigurator.configure(loggerContext);
            }
        }
    }

    public URL findURLOfDefaultConfigurationFile() {
        ClassLoader loader = LoaderUtil.findClassLoader(this);
        URL url = findConfigFileURLFromSystemProperties(loader);
        if (url != null) {
            return url;
        }
        return getResource(AUTOCONFIG_FILE, loader);
    }


    private URL findConfigFileURLFromSystemProperties(ClassLoader loader) {
        String logbackCF = System.getProperty(CONFIG_FILE_PROPERTY);
        if (logbackCF != null) {
            URL url;
            try {
                url = new URL(logbackCF);
            } catch (MalformedURLException e) {
                url = loader.getResource(logbackCF);
                if (url != null) {
                    return url;
                }
                File f = new File(logbackCF);
                if (f.exists() && f.isFile()) {
                    try {
                        return f.toURI().toURL();
                    } catch (MalformedURLException e1) {
                    }
                }
            }
        }
        return null;
    }

    private URL getResource(String config, ClassLoader loader) {
        return loader.getResource(config);
    }

    public void configureByResource(URL url) {
        if (url == null) {
            throw new IllegalArgumentException("URL argument cannot be null");
        }
        final String urlString = url.toString();
        if (urlString.endsWith("xml")) {

            //TODO
        } else {
            throw new IllegalArgumentException("Unexpected filename extension of file [" + url.toString() + "]. Should be either .groovy or .xml");
        }
    }

}
