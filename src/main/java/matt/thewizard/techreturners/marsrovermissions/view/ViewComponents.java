package matt.thewizard.techreturners.marsrovermissions.view;

public class ViewComponents {

    //Global
    public static final int DISPLAY_WIDTH = 136;

    //Welcome Components
    private static final String WELCOME_COMPONENT_1 = "-";
    private static final String WELCOME_COMPONENT_2 = "   Welcome to the   ";
    private static final int WELCOME_TOP_LINE_PADDING = (DISPLAY_WIDTH - WELCOME_COMPONENT_2.length()) / 2;

    public static final String WELCOME_TOP_LINE_MESSAGE = WELCOME_COMPONENT_1.repeat(WELCOME_TOP_LINE_PADDING) + WELCOME_COMPONENT_2 + WELCOME_COMPONENT_1.repeat(WELCOME_TOP_LINE_PADDING);
    public static final String WELCOME_BOTTOM_LINE_MESSAGE = WELCOME_COMPONENT_1.repeat(DISPLAY_WIDTH);

    //ascii text generator 'isometric2' font
    public static final String MARS_ROVER_MESSAGE = """
                  ___           ___           ___           ___                    ___           ___                         ___           ___    \s
                 /\\  \\         /\\  \\         /\\  \\         /\\__\\                  /\\  \\         /\\  \\          ___          /\\__\\         /\\  \\   \s
                |::\\  \\       /::\\  \\       /::\\  \\       /:/ _/_                /::\\  \\       /::\\  \\        /\\  \\        /:/ _/_       /::\\  \\  \s
                |:|:\\  \\     /:/\\:\\  \\     /:/\\:\\__\\     /:/ /\\  \\              /:/\\:\\__\\     /:/\\:\\  \\       \\:\\  \\      /:/ /\\__\\     /:/\\:\\__\\ \s
              __|:|\\:\\  \\   /:/ /::\\  \\   /:/ /:/  /    /:/ /::\\  \\            /:/ /:/  /    /:/  \\:\\  \\       \\:\\  \\    /:/ /:/ _/_   /:/ /:/  / \s
             /::::|_\\:\\__\\ /:/_/:/\\:\\__\\ /:/_/:/__/___ /:/_/:/\\:\\__\\          /:/_/:/__/___ /:/__/ \\:\\__\\  ___  \\:\\__\\  /:/_/:/ /\\__\\ /:/_/:/__/___
             \\:\\~~\\  \\/__/ \\:\\/:/  \\/__/ \\:\\/:::::/  / \\:\\/:/ /:/  /          \\:\\/:::::/  / \\:\\  \\ /:/  / /\\  \\ |:|  |  \\:\\/:/ /:/  / \\:\\/:::::/  /
              \\:\\  \\        \\::/__/       \\::/~~/~~~~   \\::/ /:/  /            \\::/~~/~~~~   \\:\\  /:/  /  \\:\\  \\|:|  |   \\::/_/:/  /   \\::/~~/~~~~\s
               \\:\\  \\        \\:\\  \\        \\:\\~~\\        \\/_/:/  /              \\:\\~~\\        \\:\\/:/  /    \\:\\__|:|__|    \\:\\/:/  /     \\:\\~~\\    \s
                \\:\\__\\        \\:\\__\\        \\:\\__\\         /:/  /                \\:\\__\\        \\::/  /      \\::::/__/      \\::/  /       \\:\\__\\   \s
                 \\/__/         \\/__/         \\/__/         \\/__/                  \\/__/         \\/__/        ~~~~           \\/__/         \\/__/   \s
                        
            """;

    public static final String MISSIONS_MESSAGE = """
                                           ___                       ___           ___                       ___           ___    \s
                                          /\\  \\                     /\\__\\         /\\__\\                     /\\  \\         /\\  \\   \s
                                         |::\\  \\       ___         /:/ _/_       /:/ _/_       ___         /::\\  \\        \\:\\  \\  \s
                                         |:|:\\  \\     /\\__\\       /:/ /\\  \\     /:/ /\\  \\     /\\__\\       /:/\\:\\  \\        \\:\\  \\ \s
                                       __|:|\\:\\  \\   /:/__/      /:/ /::\\  \\   /:/ /::\\  \\   /:/__/      /:/  \\:\\  \\   _____\\:\\  \\\s
                                      /::::|_\\:\\__\\ /::\\  \\     /:/_/:/\\:\\__\\ /:/_/:/\\:\\__\\ /::\\  \\     /:/__/ \\:\\__\\ /::::::::\\__\\
                                      \\:\\~~\\  \\/__/ \\/\\:\\  \\__  \\:\\/:/ /:/  / \\:\\/:/ /:/  / \\/\\:\\  \\__  \\:\\  \\ /:/  / \\:\\~~\\~~\\/__/
                                       \\:\\  \\        ~~\\:\\/\\__\\  \\::/ /:/  /   \\::/ /:/  /   ~~\\:\\/\\__\\  \\:\\  /:/  /   \\:\\  \\     \s
                                        \\:\\  \\          \\::/  /   \\/_/:/  /     \\/_/:/  /       \\::/  /   \\:\\/:/  /     \\:\\  \\    \s
                                         \\:\\__\\         /:/  /      /:/  /        /:/  /        /:/  /     \\::/  /       \\:\\__\\   \s
                                          \\/__/         \\/__/       \\/__/         \\/__/         \\/__/       \\/__/         \\/__/   \s
            
            """;


    //Grid Components
    public static final String GRID_COMPONENT_1 = "********";
    public static final String GRID_COMPONENT_2 = "|       ";
    public static final String GRID_COMPONENT_3 = "*";
    public static final String GRID_COMPONENT_4 = "|";
    public static final int BOX_HEIGHT = 3;

    public static final String INDENT = "      ";
}
