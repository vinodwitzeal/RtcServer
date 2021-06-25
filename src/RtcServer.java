import io.agora.media.RtcTokenBuilder;

import java.util.concurrent.TimeUnit;

public class RtcServer {
    static String appId = "95318a53f4974d1faedbc805626d5b20";
    static String appCertificate = "22e09d33797d44428d3959149eee35d5";

    public static void main(String[] args) throws Exception {
        System.out.println(buildTokenForRoom("1234", TimeUnit.HOURS.toSeconds(2)));
    }

    public static String buildTokenForRoom(String roomId,long expirationTimeInSeconds){
        RtcTokenBuilder token = new RtcTokenBuilder();
        int timestamp = (int)(System.currentTimeMillis() / 1000 + expirationTimeInSeconds);
        return token.buildTokenWithUid(appId,appCertificate,roomId,0, RtcTokenBuilder.Role.Role_Publisher,timestamp);
    }
}
