package com.jtelaa.da2.lib.console;

import java.nio.file.Files;
import java.nio.file.Paths;

import com.jtelaa.da2.lib.control.ComputerControl;
import com.jtelaa.da2.lib.files.FileUtil;
import com.jtelaa.da2.lib.log.Log;

/**
 * Prints out the banners into the console
 * 
 * @since 1
 * @author Joseph
 */

 // TODO Add ability to specify internal/external

public class ConsoleBanners {
    /** Path is internal */
    public static volatile int INTERNAL = 0;

    /** Path is external */
    public static volatile int EXTERNAL = 1;

    /** Internal banner path */
    private static String BANNER_PATH = "~/banners/";

    /**
     * Test prints banners
     */
    public static void main(String[] args) {
        System.out.println(mainBanner(ConsoleColors.YELLOW_BOLD_BRIGHT));
        System.out.println(directorBanner(ConsoleColors.GREEN_BOLD_BRIGHT));

    }

    /**
     * Loads remote banners from the git repo and requires the ~/banners/ directory to exists
     * 
     * @param program_name Name of the program to get its specific banner
     */

    public static void loadRemoteBanners(String program_name) {
        // If directory exists, create it
        if (Files.isDirectory(Paths.get(BANNER_PATH))) {
            Log.sendLogMessage("Banner directory not found. Creating....", ConsoleColors.YELLOW);
            ComputerControl.sendCommand("mkdir " + BANNER_PATH);
            
        }

        // Get banners
        Log.sendManSysMessage("Loading banners");
        ComputerControl.sendCommand("cd " + BANNER_PATH + " && curl https://raw.githubusercontent.com/DA2Botnet/DA2Botnet.github.io/main/banners/MainBanner.txt > MainBanner.txt");
        ComputerControl.sendCommand("cd " + BANNER_PATH + " && curl https://raw.githubusercontent.com/DA2Botnet/DA2Botnet.github.io/main/banners/QueryGen.txt > " + program_name + ".txt");

    }

    /**
     * Loads remote banners from the git repo 
     * 
     * @param program_name Name of the program to get its specific banner
     * @param banner_path Path of the banners
     */

    public static void loadRemoteBanners(String program_name, String banner_path) {
        BANNER_PATH = banner_path;
        loadRemoteBanners(program_name);

    }

    /**
     * Prints the main banner
     * 
     * @return The banner
     */

    public static String mainBanner() { return FileUtil.readInternalFile(BANNER_PATH + "MainBanner.txt"); }

    /**
     * Prints the main banner
     * 
     * @param color 
     * 
     * @see com.jtelaa.da2.lib.console.ConsoleColors.java
     * 
     * @return The banner
     */

    public static String mainBanner(ConsoleColors color) { return color.getColor() + mainBanner() + ConsoleColors.RESET.getEscape(); }

    /**
     * Prints the director banner
     * 
     * @return The banner
     */

    public static String directorBanner() { return FileUtil.readInternalFile(BANNER_PATH + "Director.txt"); }

    /**
     * Prints the director banner
     * 
     * @param color 
     * 
     * @see com.jtelaa.da2.lib.console.ConsoleColors.java
     * 
     * @return The banner
     */

    public static String directorBanner(ConsoleColors color) { return color.getColor() + directorBanner() + ConsoleColors.RESET.getEscape(); }

    /**
     * Prints the bot banner
     * 
     * @return The banner
     */

    public static String botBanner() { return FileUtil.readInternalFile(BANNER_PATH + "Bot.txt"); }

    /**
     * Prints the bot banner
     * 
     * @param color 
     * 
     * @see com.jtelaa.da2.lib.console.ConsoleColors.java
     * 
     * @return The banner
     */

    public static String botBanner(ConsoleColors color) { return color.getColor() + mainBanner() + ConsoleColors.RESET.getEscape(); }

    /**
     * Prints the hypervisor banner
     * 
     * @return The banner
     */

    public static String hypervisorBanner() { return FileUtil.readInternalFile(BANNER_PATH + "Hypervisor.txt"); }

    /**
     * Prints the hypervisor banner
     * 
     * @param color 
     * 
     * @see com.jtelaa.da2.lib.console.ConsoleColors.java
     * 
     * @return The banner
     */

    public static String hypervisorBanner(ConsoleColors color) { return color.getColor() + hypervisorBanner() + ConsoleColors.RESET.getEscape(); }

    /**
     * Prints the hypervisor banner
     * 
     * @return The banner
     */

    public static String otherBanner(String path) { return otherBanner(path, INTERNAL); }

    /**
     * Prints the hypervisor banner
     * 
     * @param path Path of the banner
     * @param type Internal or External
     * 
     * @return The banner
     */

    public static String otherBanner(String path, int type) { 

        if (type == EXTERNAL) {
            return FileUtil.readFile(path);

        } else {
            return FileUtil.readInternalFile(path); 

        }
        
    }

    /**
     * Prints the hypervisor banner
     * 
     * @param color 
     * 
     * @see com.jtelaa.da2.lib.console.ConsoleColors.java
     * 
     * @return The banner
     */

    public static String otherBanner(String path, ConsoleColors color) { return color.getColor() + otherBanner(path) + ConsoleColors.RESET.getEscape(); }

    /**
     * Prints the hypervisor banner
     * 
     * @param color 
     * @param type Internal or External
     * 
     * @see com.jtelaa.da2.lib.console.ConsoleColors.java
     * 
     * @return The banner
     */

    public static String otherBanner(String path, int type, ConsoleColors color) { return color.getColor() + otherBanner(path, type) + ConsoleColors.RESET.getEscape(); }


}