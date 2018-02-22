package al.dmullaraj.di.factorycontainerimageexplorer.application.classfactory;

/**
 * Created by denis.mullaraj on 22/02/2018.
 */

public class ClassWiring {
    private static ClassFactory sClassFactory;

    public static void setClassFactory(ClassFactory classFactory){
        sClassFactory = classFactory;
    }

    public static ClassFactory getClassFactory(){
        return sClassFactory;
    }
}
