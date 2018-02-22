package al.dmullaraj.di.factorycontainerimageexplorer.application;

import android.app.Application;

import al.dmullaraj.di.factorycontainerimageexplorer.application.classfactory.ClassFactory;
import al.dmullaraj.di.factorycontainerimageexplorer.application.classfactory.ClassWiring;
import al.dmullaraj.di.factorycontainerimageexplorer.application.classfactory.impl.ClassFactoryImpl;

/**
 * Created by denis.mullaraj on 22/02/2018.
 */

public class ImageExplorerApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ClassFactory classFactory = new ClassFactoryImpl(getApplicationContext());
        ClassWiring.setClassFactory(classFactory);
    }
}