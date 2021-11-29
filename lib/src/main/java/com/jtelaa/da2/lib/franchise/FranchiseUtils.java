package com.jtelaa.da2.lib.franchise;

import com.jtelaa.da2.lib.net.NetTools;

public class FranchiseUtils {

    /**
     * 
     * @return
     */

    public static String resolveDefaultDBIP() {
        String my_ip = NetTools.getLocalIP();

        return my_ip.substring(0, my_ip.lastIndexOf(".")) + 2;
    }

    /**
     * 
     * @return
     */

    public static String resolveDefaultLogIP() {
        String my_ip = NetTools.getLocalIP();

        return my_ip.substring(0, my_ip.lastIndexOf(".")) + 1;
    }
    
}
