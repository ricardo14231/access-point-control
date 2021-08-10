package dio.innovation.accessPointAPI.messageResponse;

public class MessageResponse {

    public static String messageObjCreate(Long id, String typeObject) {
        return String.format("%s salvo(a) com id: %o.", typeObject, id);
    }

    public static String messageObjUpdate(Long id, String typeObject) {
        return String.format("%s com ID: %o atualizado(a) com sucesso!", typeObject, id);
    }

    public static String messageObjDelete(Long id, String typeObject) {
        return String.format("%s com ID: %o deletado(a) com sucesso!", typeObject, id);
    }
}
