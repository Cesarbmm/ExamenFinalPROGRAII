package Framework;

public class ZCException extends Exception {

    public ZCException(String e, String clase, String metodo) {
        //grabar el log
        System.out.println("[ERROR APP --> LOG] " + clase +"."+ metodo +" : "+ e );
    }

    @Override 
    public String getMessage(){
        return "IPs..! se presento un error..";
    }    
}