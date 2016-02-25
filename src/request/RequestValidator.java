package request;

import response.*;
import utilities.IOHelper;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * Created by johanrovala on 17/02/16.
 * Basic functionality of this class regards checking our Request object and sending the
 * appropriate respons depending on the data of the Request object.
 */
public class RequestValidator {

    /**
     * Fields
     */

    private static boolean canViewSecretPage = false;
    IOHelper ioHelper;
    Request request;

    public RequestValidator(Request request){
        this.request = request;
        this.ioHelper = new IOHelper();
    }

    private boolean fileExists(String path){
        return ioHelper.fileExist(path);
    }

    private boolean isGet(String requestType){
        return requestType.equals("GET");
    }

    private boolean isPost(String requestType){
        return requestType.equals(HTTP_RequestType.POST);
    }

    private boolean isPut(String requestType){
        return requestType.equals(HTTP_RequestType.PUT);
    }


    /*
     * General method to check the validity of the Request. A new response is given dependant of the data.
     */

    public HTTPResponse getResponse(boolean canView5timesPage) throws IOException
    {
        if (!isGet(request.getRequestType()))
        {
            System.out.println("IT'S A GET REQUEST!!!");
            return new R405METHODNOTALLOWED(false);
        }
        if (request.getPath().contains("brew") && request.getPath().contains("coffee"))
        {
            return new R418IMATEAPOT(false);
        }
        if(fileExists(request.getPath()) && ioHelper.isAllowedDir(request.getPath()))
        {
            return properResponse(request, canView5timesPage);
        }
        else if(!fileExists(request.getPath()))
        {
            System.out.println("\nA file that does not exist got a request for access but got denied\n" +
                    "The file name is: " + request.getPath());
            return new R404NOTFOUND(true);
        }
        else if(!ioHelper.isAllowedDir(request.getPath()))
        {
            System.out.println("\nUser try to access a file that it is not allowed to access with path name" +
                    request.getPath() + "\n\n");
            return new R403FORBIDDEN(true);
        }
        else
        {
            return new R500INTERNALSERVERERROR(true);
        }
    }

    private HTTPResponse properResponse(Request request, boolean canView5timesPage) throws IOException
    {
        if (request.getPath().contains("fiveTimes"))
        {
            System.out.println("The fivetimes file was requested");
            if (!canView5timesPage)
            {
                System.out.println("The system doesn't think the user can see the fivetimes file");
                return new R412PRECONDITIONFAILED(true);
            }
        }
        else if(request.getPath().equals("src/html/secretpage.html"))
        {
            System.out.println("User tries to access the secret page");
            if (!canViewSecretPage)
            {
                return new R402PAYMENTREQUIRED(false);
            }
            else
            {
                return new R200OK(Paths.get(request.getPath()), getContentType(request.getPath()), true);
            }
        }
        System.out.println("File with path " + request.getPath() + " exists and gets returned." );
        if (request.getPath().equals("src/html/jakobandjohanwillgetAforassignment2.html"))
        {
            canViewSecretPage = true;
        }

        /*
         * DENNA KOMMENTAR TAS BORT INNAN INLÄMNING.
         * Tänkte bara förklara nedanstående. En liten fulfix så vi kan checka ifall
         * det anv försöker skriva in innehåller en faktisk fil (genom att leta efter punkter, borde hålla rätt bra)
         * om icke skickar vi bara iväg dom till index. vid detta utfall har vi även hunnit kolla så det är ett lagligt
         * dir och allt sånt.
         */

        if(ioHelper.pathContainsFile(request.getPath())){
            System.out.println("File with path " + request.getPath() + " exists and gets returned." );
            return new R200OK(Paths.get(request.getPath()), getContentType(request.getPath()), true);
        }
        else {
            System.out.println("User tries to access dir " + request.getPath() + " and gets redirected to index.html" );
            return new R200OK(Paths.get("src/html/index.html"), getContentType("src/html/index.html"), true);
        }
    }


    /*
     * Private help method to check the content-type of the Request and return it as a CONTENT_TYPE enum.
     */
    private CONTENT_TYPE getContentType(String pathOfFile)
    {
        String test = ioHelper.getFileEnding(pathOfFile);

        for (CONTENT_TYPE t : CONTENT_TYPE.values()){

            if(t.toString().endsWith(test)){
                return t;
            }
        }
        return CONTENT_TYPE.unknown;
    }
}
