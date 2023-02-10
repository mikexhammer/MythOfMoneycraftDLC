package ascii_art;

import helper.Ausgabe;
import helper.ConsoleColors;

public class Game {


    public static void titel() {
        System.out.println(ConsoleColors.RED +
                Ausgabe.paddingText(6) + "     . .    .       .   .    . .       . .    .    .       . .  \n" +
                Ausgabe.paddingText(6) + "  .+'|=|`+.=|`+. .+'|.+'| .+'|=|`+. .+'|=|`+.=|`+. |`+. .+'|=|`+.\n" +
                Ausgabe.paddingText(6) + "  |  | `+ | `+ | |  ||  | |  | `+.| |.+' |  | `+.| |  | |  | `+.|\n" +
                Ausgabe.paddingText(6) + "  |  |  | |  | | `+.`'.+' |  | .         |  |      |  | |  |     \n" +
                Ausgabe.paddingText(6) + "  |  |  | |  | |   |  |   `+.|=|`+.      |  |      |  | |  |     \n" +
                Ausgabe.paddingText(6) + "  |  |  | |  | |   |  |   .    |  |      |  |      |  | |  |    .\n" +
                Ausgabe.paddingText(6) + "  |  |  | |  | |   |  |   |`+. |  |      |  |      |  | |  | .+'|\n" +
                Ausgabe.paddingText(6) + "  `+.|  |.|  |+'   |.+'   `+.|=|.+'      |.+'      |.+' `+.|=|.+'\n" +
                Ausgabe.paddingText(6) + "                                                                 \n" +
                ConsoleColors.RESET

        );
        System.out.println(ConsoleColors.YELLOW +
                        "                                    8 8888     ,88' b.             8  8 8888     ,o888888o.    8 8888        8 8888888 8888888888    d888888o.   \n" +
                        "                       -#*          8 8888    ,88'  888o.          8  8 8888    8888     `88.  8 8888        8       8 8888        .`8888:' `88. \n" +
                        "                      :%@:          8 8888   ,88'   Y88888o.       8  8 8888 ,8 8888       `8. 8 8888        8       8 8888        8.`8888.   Y8 \n" +
                        "    ::                +%%=          8 8888  ,88'    .`Y888888o.    8  8 8888 88 8888           8 8888        8       8 8888        `8.`8888.     \n" +
                        " .*%%@%-=++=++=++++=+=%%%##@%%@%%%@@8 8888 ,88'     8o. `Y888888o. 8  8 8888 88 8888           8 8888        8       8 8888         `8.`8888.    \n" +
                        " :@@@@@+%#%%%%%%@%%@%+@@@#%@@@@%####8 8888 88'      8`Y8o. `Y88888o8  8 8888 88 8888           8 8888        8       8 8888          `8.`8888.   \n" +
                        "   -++:               #@@*----------8 888888<       8   `Y8o. `Y8888  8 8888 88 8888   8888888 8 8888888888888       8 8888           `8.`8888.  \n" +
                        "                      -@@:          8 8888 `Y8.     8      `Y8o. `Y8  8 8888 `8 8888       .8' 8 8888        8       8 8888       8b   `8.`8888. \n" +
                        "                       *@+          8 8888   `Y8.   8         `Y8o.`  8 8888    8888     ,88'  8 8888        8       8 8888       `8b.  ;8.`8888 \n" +
                        "                        .:          8 8888     `Y8. 8            `Yo  8 8888     `8888888P'    8 8888        8       8 8888        `Y8888P ,88P' \n" +
                ConsoleColors.RESET
        );
    }

    public static void kampf() {
        System.out.println(


                ConsoleColors.BLUE + "                               ...                            "+ConsoleColors.YELLOW+"                                                                          "+ConsoleColors.RESET+ ConsoleColors.RED+"            +%%@%*-=+*%+::*###:        "+ConsoleColors.RESET+"\n"+
                ConsoleColors.BLUE + "                          :::=***.               .=*    .-+.  "+ConsoleColors.YELLOW+"   @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ "+ConsoleColors.RESET+ ConsoleColors.RED+"          -@@%###*==#%%*=-=+%#%*.      "+ConsoleColors.RESET+"\n"+
                ConsoleColors.BLUE + "                       .#@%+=+*+                 +@%%#%%@@+   "+ConsoleColors.YELLOW+"   @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ "+ConsoleColors.RESET+ ConsoleColors.RED+"         *@%%##%#*##%#==+##**#%#@-     "+ConsoleColors.RESET+"\n"+
                ConsoleColors.BLUE + "                       %@***%%@%                 %@++%@@@@.-  "+ConsoleColors.YELLOW+"   @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%@@@@@@@@@@@@@@@@@@@@@@@@@@@ "+ConsoleColors.RESET+ ConsoleColors.RED+"        #%%#*%*+=:+#      +@%**#*%-    "+ConsoleColors.RESET+"\n"+
                ConsoleColors.BLUE + "                      *@@@%#%@@@.               :@%   %@@- -  "+ConsoleColors.YELLOW+"   %%%%%@@@@@@@@@@@@@%%%#%%%%%#%@@@@@@@@@@@%#%##%#%%%#%@@@@@@@@@@@@%%%%%% "+ConsoleColors.RESET+ ConsoleColors.RED+"       #%%+***+.  -*=.     .+**#%%%:   "+ConsoleColors.RESET+"\n"+
                ConsoleColors.BLUE + "              :=+**##%%%%%=*%*=#                #@=   #@= =   "+ConsoleColors.YELLOW+"   @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%%%%%@%@@@@@@@@@@@@@@@@@@@@ "+ConsoleColors.RESET+ ConsoleColors.RED+"      *%%+++++*+=:  ..=  :=++=:##%@@=  "+ConsoleColors.RESET+"\n"+
                ConsoleColors.BLUE + "             .+*##****##%@#=+%@-               .@@    =* -.   "+ConsoleColors.YELLOW+"   @@@@@@@@@@@@@@@@@@*+****#@@@@@@@@*****+#%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ "+ConsoleColors.RESET+ ConsoleColors.RED+"     +%*+#%*:..:-=: :.- :=-....=#-*@@- "+ConsoleColors.RESET+"\n"+
                ConsoleColors.BLUE + "            +###*#*+--*#%@####*=-              +@+     ==.    "+ConsoleColors.YELLOW+"   @@@@@@@@@@@@@@@@@@+     .%@@%%%%+     :%%#####%@@@@@@@@@@@@@@@@@@@@@@@ "+ConsoleColors.RESET+ ConsoleColors.RED+"     %*%%@+-=++#=: .   ..:+#=+-:@###%#."+ConsoleColors.RESET+"\n"+
                ConsoleColors.BLUE + "           :.*%=+#%%%#++%@%#@#++@@*:           %@.      .     "+ConsoleColors.YELLOW+"   @@@@@@@@@@@@@@@@@%%-     -#%%%%#      :         :+%@@@@@@@@@@@@@@@@@@@ "+ConsoleColors.RESET+ ConsoleColors.RED+"     @#%@*#  ----:      .:---: .%%*#%%."+ConsoleColors.RESET+"\n"+
                ConsoleColors.BLUE + "           .=#+*##%#*******+*+#. =%@#.        :@#             "+ConsoleColors.YELLOW+"   @@@@@@@@@@@@@@@@%%%#.     *####:         .::.     .#@@@@@@@@@@@@@@@@@@ "+ConsoleColors.RESET+ ConsoleColors.RED+"     ##%#*#==++#=-       -+#++-=#+%**- "+ConsoleColors.RESET+"\n"+
                ConsoleColors.BLUE + "          =###**#@%##++%%**#*#.    +@@-       *@-             "+ConsoleColors.YELLOW+"   @@@@@@@%@@@@@@@%%%%#*     .##*+     .    #%%%*  ...=@%%@@@@@@@@@@@@@@@ "+ConsoleColors.RESET+ ConsoleColors.RED+"     -#%%==%.-:-::.     .:--:- #++%@=  "+ConsoleColors.RESET+"\n"+
                ConsoleColors.BLUE + "         =@*@%%%%%@%#%@#*###@@#:    :@@-      @@              "+ConsoleColors.YELLOW+"   @@@@@@%%%%%###%##%%%#+     =#*.    .      .:-=+*%@@@@#%%#%%%%%#@@@@@@@ "+ConsoleColors.RESET+ ConsoleColors.RED+"      %#%%##.      .. .    .  .#@%%%-  "+ConsoleColors.RESET+"\n"+
                ConsoleColors.BLUE + "        .@@*@@*@*@##+#*#@@@@@@@@#-..:+%#    =#@#              "+ConsoleColors.YELLOW+"   @@@@@@@@@@@@%%%%%%%###-     *-     *+:           .=%@%@@@@@@@@@@@@@@@@ "+ConsoleColors.RESET+ ConsoleColors.RED+"      -#*%#%*      :==--    . *%###=.  "+ConsoleColors.RESET+"\n"+
                ConsoleColors.BLUE + "        +@%+@@%*#*@@-%##@@@@@@##@%@*+*****+%@@@@.             "+ConsoleColors.YELLOW+"   @@@@@@@@@@@@@@@%%%%####.    :     +#%%#*=-:.       .%@@@@@@@@@@@@@@@@@ "+ConsoleColors.RESET+ ConsoleColors.RED+"        -#%#=:    +%###%+    =###.     "+ConsoleColors.RESET+"\n"+
                ConsoleColors.BLUE + "        *@*@@*@+@-%#*#*###*%%+@=@*@ %@@@@#.=#@@-              "+ConsoleColors.YELLOW+"   @@@@@@@@@@@@@@@@@%%####*         -*===--+%%%%*.     +@@@@@@@@@@@@@@@@@ "+ConsoleColors.RESET+ ConsoleColors.RED+"        .**-- -:    :-.    .::%*:      "+ConsoleColors.RESET+"\n"+
                ConsoleColors.BLUE + "        *#%@@+@+@%+*%=%+#@:%*-::+-*.-=##=   +@+               "+ConsoleColors.YELLOW+"   @@@@@@@@@@@@@@@@@%%%%###+       .##      +%@@#:     #@@@@@@@@@@@@@@@@@ "+ConsoleColors.RESET+ ConsoleColors.RED+"        *+-  .-:--:     :-::+-%:       "+ConsoleColors.RESET+"\n"+
                ConsoleColors.BLUE + "        :%@@+%=%@%:@=%+%%@:@@*       :@@:   %@.               "+ConsoleColors.YELLOW+"   @@@@@@@@@@@@@@@@@%%%%%###=-:::--#%%*.             .*@@@@@@@@@@@@@@@@@@ "+ConsoleColors.RESET+ ConsoleColors.RED+"        :==. .==-:-=***+-:-+: -*-.     "+ConsoleColors.RESET+"\n"+
                ConsoleColors.BLUE + "        #@@*+%:@@#.@@=#**%+##+       %@*   -@%                "+ConsoleColors.YELLOW+"   @@@@@@@@@@@@@@@@@%%#%#%#########%%%%%*-:.     .:=*%@@@@@@@@@@@@@@%%@@@ "+ConsoleColors.RESET+ ConsoleColors.RED+"        .  . .=@%#***#*=*#%@=. -..     "+ConsoleColors.RESET+"\n"+
                ConsoleColors.BLUE + "       -@@*:@-+@@% @@@++#+%@@@.    .%@*    #@+                "+ConsoleColors.YELLOW+"   %%%%%@@@@@@@@@@@@@######*****#*%@%%%%@@@%##*#####%#%@@@@@@@@@@@@%%%%%% "+ConsoleColors.RESET+ ConsoleColors.RED+"             ==+*%@+#@+*@%*+*:  .      "+ConsoleColors.RESET+"\n"+
                ConsoleColors.BLUE + "       =@@.#@:+@@@=-@@%%++#*#@:  .+@@=    :@@:                "+ConsoleColors.YELLOW+"   @@@@@@@@@@@@@@@@@@%%%%%%%#####%@@@@@@@@@@@%@@@@@@@@@@@@@@@@@@@@@@@@@@@ "+ConsoleColors.RESET+ ConsoleColors.RED+"     ::-:::=*@@@*+++--=++=+%%%*=:::--: "+ConsoleColors.RESET+"\n"+
                ConsoleColors.BLUE + "        %@ %@+.@@@@+:%@*#@**#*=.+@@+.     #@@                 "+ConsoleColors.YELLOW+"   @@@@@@@@@@@@@@@@@@@@@@@%%%%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ "+ConsoleColors.RESET+ ConsoleColors.RED+"     ===+%@@@@@@@@@@%*#@@@@@@@@@%%*=== "+ConsoleColors.RESET+"\n"+
                ConsoleColors.BLUE + "         *-+@@-:%%#@@++*%*+#@#%%#*=.      -+=                 "+ConsoleColors.YELLOW+"   @@@@@@@@@@@@@@@@@@@@@@@@@%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ "+ConsoleColors.RESET+ ConsoleColors.RED+"     :-==+@@@@@@@@@@%*#@@@@@@@@@@+==-: "+ConsoleColors.RESET+"\n"+
                ConsoleColors.BLUE + "          . #@@+.+@#*#@@#%@%+++#@@@@@%*=:                     "+ConsoleColors.YELLOW+"   @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ "+ConsoleColors.RESET+ ConsoleColors.RED+"      :=---%@@@@@@@@##*@@@@@@@@%===-:  "+ConsoleColors.RESET+"\n"+
                ConsoleColors.BLUE + "             -+*#-.+%@****#%%%#+-:-+*#%%@@%*-                 "+ConsoleColors.YELLOW+"   %####%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ "+ConsoleColors.RESET+ ConsoleColors.RED+"       .=-=-*%@@@@@@@=%@@@@@@%*==--:   "+ConsoleColors.RESET+"\n"+
                ConsoleColors.BLUE + "                     :=-:.                .:-+-               "+ConsoleColors.YELLOW+"                                                                          "+ConsoleColors.RESET+ ConsoleColors.RED+"         -----+*#%@@@+%@@%#*=----:     "+ConsoleColors.RESET+"\n"+
                ConsoleColors.BLUE + "                                                              "+ConsoleColors.YELLOW+"                                                                          "+ConsoleColors.RESET+ ConsoleColors.RED+"           .---=-==-==--===--=::       "+ConsoleColors.RESET+"\n"+
                ConsoleColors.BLUE + "                                                              "+ConsoleColors.YELLOW+"                                                                          "+ConsoleColors.RESET+ ConsoleColors.RED+"             .:-=-:::--==-:.          "+ConsoleColors.RESET+"\n"+
                ConsoleColors.BLUE + "                                                              "+ConsoleColors.YELLOW+"                                                                          "+ConsoleColors.RESET+ ConsoleColors.RED+"                  .....               "+ConsoleColors.RESET+"\n"


        );
    }

    public static void kampfNeu(){
        System.out.println(


                ConsoleColors.BLUE+"                            =##=                     "+ConsoleColors.YELLOW+"                                                     "+ConsoleColors.RED+"              .-==-:  ..             \n"+
                ConsoleColors.BLUE+"                         ..-+#%%=                    "+ConsoleColors.YELLOW+"                                                     "+ConsoleColors.RED+"           .-+##***#+#+++*-          \n"+
                ConsoleColors.BLUE+"                        +==--+%@%%-                  "+ConsoleColors.YELLOW+"                                                     "+ConsoleColors.RED+"          =#%%#*--+*#+::+**#:        \n"+
                ConsoleColors.BLUE+"                        +%%+-=*%%%*-                 "+ConsoleColors.YELLOW+"                                                     "+ConsoleColors.RED+"        -%%##*#*==*##*=-=+%##*.      \n"+
                ConsoleColors.BLUE+"                     . .+#%=.:+=:=                   "+ConsoleColors.YELLOW+"                                                     "+ConsoleColors.RED+"       +%####%*+*##*==+#***##*%-     \n"+
                ConsoleColors.BLUE+"                   .:.::+*%+.:+- ..:.:               "+ConsoleColors.YELLOW+"                                                     "+ConsoleColors.RED+"      *#%*+#*+=:+#.     +%#+***%-    \n"+
                ConsoleColors.BLUE+"                  :-+=.+%#%####=:-=+-.-:.:==+=       "+ConsoleColors.YELLOW+"                                                     "+ConsoleColors.RED+"     *%%++*+=.  -+=.     .+*+*##%:   \n"+
                ConsoleColors.BLUE+"                 :++++++***+#%+=+++*##%@@%%###=      "+ConsoleColors.YELLOW+"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@    "+ConsoleColors.RED+"   *%#+=+++++=:  ..=  :-===:**#%%-  \n"+
                ConsoleColors.BLUE+"                 =+++***-.-++##+*#%@%#*+-::...+      "+ConsoleColors.YELLOW+"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@    "+ConsoleColors.RED+" .+#*=*#+:..:-=:.::- :=-....=#-*%%- \n"+
                ConsoleColors.BLUE+"                  +###*+:.-====*%#++=:..::---.-:     "+ConsoleColors.YELLOW+"%%%@@@@@@@@@%%%%%%%@@@@@@@@@%%%%%%%%@@@@@@@@@%%%%    "+ConsoleColors.RED+" =%+##%+-=++#=: .   ..:+*=+-:%**###.\n"+
                ConsoleColors.BLUE+"                  ####*+-.=++++#%%++:==++++++:.-     "+ConsoleColors.YELLOW+"@@@@@@@@@@@@@@@@@@@@@@@@@@@#%%%%%@@@@@@@@@@@@@@@@    "+ConsoleColors.RED+"=@##%*#  ----:.     .:---:..%#*###.\n"+
                ConsoleColors.BLUE+"                .+####=+=.-++++*@@*++++++*%#+=.-     "+ConsoleColors.YELLOW+"@@@@@@@@@@@%:   -@@%%%-   :%%##%%@@@@@@@@@@@@@@@@    "+ConsoleColors.RED+" =#*%*+#==++*=-      .-=*++--#+#+*- \n"+
                ConsoleColors.BLUE+"                +++**=:++:-++++*%@#++++++%@@@#:-     "+ConsoleColors.YELLOW+"@@@@@@@@@@@%#    +#%#+    .      .=%@@@@@@@@@@@@@    "+ConsoleColors.RED+"  -###-=#.-:-::.     .:--:-.*+=%%=  \n"+
                ConsoleColors.BLUE+"                *###+::+++-++++*%@@+++++#@@@@@=:.    "+ConsoleColors.YELLOW+"@@@@@@@@@@%%#+    *#*.      -#*-   :@@@@@@@@@@@@@    "+ConsoleColors.RED+"   ##%%##.      .. ..   .  .*%%##-. \n"+
                ConsoleColors.BLUE+"                ###+=#*+*******#*%@#+++++#%@@*+.:    "+ConsoleColors.YELLOW+"@@@%%%%%%%#%%#-   -#-   .    .-==*%@@%%%%%%%@@@@@    "+ConsoleColors.RED+"   -**##%+ .    :-=--    . *###*=.  \n"+
                ConsoleColors.BLUE+"             .+.***=++*******++++*@%+===+++**=+:-    "+ConsoleColors.YELLOW+"@@@@@@@@@%%%###.   =   .#*-.       =%@@@@@@@@@@@@    "+ConsoleColors.RED+"     -*#*=:   .+#*###=    =**#.     \n"+
                ConsoleColors.BLUE+"              +%%%# =**++*%%#####*%@#+=++++=+++--    "+ConsoleColors.YELLOW+"@@@@@@@@@@@%###*       *++++%#*=    +@@@@@@@@@@@@    "+ConsoleColors.RED+"     .**-- ::    :-.    .::#+:      \n"+
                ConsoleColors.BLUE+"              :+%%.  -*+##%%%####**%@+++++++++++=    "+ConsoleColors.YELLOW+"@@@@@@@@@@@%%###+     +#.   -**+    #@@@@@@@@@@@@    "+ConsoleColors.RED+"     *=-  .-:--:     :-::=-%:       \n"+
                ConsoleColors.BLUE+"            :=-.:%-  .#***####****--@%+++++**#*+.    "+ConsoleColors.YELLOW+"@@@@@@@@@@@%%####*****%%%=.      .=%@@@@@@@@@@@@@    "+ConsoleColors.RED+"     :==. .==-:-=+*++::-+: :*-.     \n"+
                ConsoleColors.BLUE+"          :--.        ++++++-++++*: :++===-:.        "+ConsoleColors.YELLOW+"%%%@@@@@@@@@####***##%%%%@@%#***#%%%@@@@@@@@@%%%%    "+ConsoleColors.RED+"     .  . .=@%*++**+=+#%@=. -..     \n"+
                ConsoleColors.BLUE+"        .-=:          -++++= ++++*:                  "+ConsoleColors.YELLOW+"@@@@@@@@@@@@@%%%%###%@@@@@@@@@@@@@@@@@@@@@@@@@@@@    "+ConsoleColors.RED+"          ===*#%+*%+*%#*++:  .      \n"+
                ConsoleColors.BLUE+"      .:-:            .*+++- :+++*.                  "+ConsoleColors.YELLOW+"@@@@@@@@@@@@@@@@%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@    "+ConsoleColors.RED+"  ::-:::=*%%%*=++--=+==+###*-:::--: \n"+
                ConsoleColors.BLUE+"    .:--.              +#*+:  -*=*.                  "+ConsoleColors.YELLOW+"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@    "+ConsoleColors.RED+" .===+#%%%@@@@@@@#**@@%%%%%%%##+=== \n"+
                ConsoleColors.BLUE+"  .:=-.                =--+:  .+=::                  "+ConsoleColors.YELLOW+"                                                     "+ConsoleColors.RED+"   :-===%@@@@@@@@@%**@@@@@@@@@%=---: \n"+
                ConsoleColors.BLUE+" .-=:                  -+==*   ++=*.                 "+ConsoleColors.YELLOW+"                                                     "+ConsoleColors.RED+"    :=---%@@@@@@@@*#*%@@@@@@@%===-:  \n"+
                ConsoleColors.BLUE+".::                     ***+=  -**+*                 "+ConsoleColors.YELLOW+"                                                     "+ConsoleColors.RED+"     .=-=-+%@@@@@@@=#%@@@@@%+==--:   \n"+
                ConsoleColors.BLUE+"                        =*++-  .++++                 "+ConsoleColors.YELLOW+"                                                     "+ConsoleColors.RED+"       --:--+*#%%@@+%%%%#+=----:     \n"+
                ConsoleColors.BLUE+"                        .*+*.   -+++                 "+ConsoleColors.YELLOW+"                                                     "+ConsoleColors.RED+"         .-:-=-=--==--===--=::       \n"+
                ConsoleColors.BLUE+"                         *++     ++=                 "+ConsoleColors.YELLOW+"                                                     "+ConsoleColors.RED+"            .:---:::---=-:.          \n"+
                ConsoleColors.BLUE+"                         +*-     :*=                 "+ConsoleColors.YELLOW+"                                                     "+ConsoleColors.RED+"               . .....               \n"+
                ConsoleColors.BLUE+"                        :=*.      *+                 "+ConsoleColors.YELLOW+"                                                     "+ConsoleColors.RED+"                                     \n"
        );
    }

    public static void maeven(){
        System.out.println(
                        "              .-*###*+..-=-:.             \n"+
                        "            -+*##++=+%##*==+##-           \n"+
                        "          =%%@%#+-:-++**- .+*+#%:         \n"+
                        "        :%@%##*#*=:-*#%#+::-=%%*%*.       \n"+
                        "       +@%#%%#%%++##*%#++**+++*%*#@-      \n"+
                        "      #%#%*+#%=+++#%-.   .=#%**+#+*@+     \n"+
                        "     #%@#+*#+*+. ==+        +@#*+*#*%=    \n"+
                        "    #%@*++++=.    -=+-.      .-=+*#%%@-   \n"+
                        "   *#%++-+=+*#*+-     -:  :-+=+=.+**%@@+  \n"+
                        " .=%*-=*#+:...:-==. -.-. -=-.....-*--#%@= \n"+
                        " =%++##%=--+++*--  :   :  :-+==+-.##++#@#-\n"+
                        "==@+@#@*+. -:-=-.:       :.:=-:- .#%*####=\n"+
                        "=-@##@**%  .---:.         .:---. .###+++#:\n"+
                        " =**%#-+**:*:=*=..       ..-*--*--%=+%**: \n"+
                        "  :*@##:-@..:::.:.       .:.:::. +#:@#@=  \n"+
                        "   ###%%##.        ..  .     .   +@%%*#-  \n"+
                        "   -#=#%##*         ...      .  +#@#**+   \n"+
                        "    .=+%*%#-.    :+**#+##-     =###*-:    \n"+
                        "      :##=- .     -*+*+*-     :++#+       \n"+
                        "      -#=.:  -:.    ..      .- -@=:       \n"+
                        "     -*-:   -- :--.     .--. +-=%.        \n"+
                        "      ++=   :-::.::=****=.::--  -*-:      \n"+
                        "         :  .=%*+---===::-+*@+:  :- .     \n"+
                        "      .     --#@@@@+@@@+%@@@#--           \n"+
                        "          .-%=+:=+*--+--*==.-+%-.         \n"+
                        " ...-::-=+*%@@@%#+*==-=-*=+#%#%%#+-----:- \n"+
                        " .--:-=%%@%@@@@@@@@@#**@@@%@%%%@@@%%+=-::.\n"+
                        "  -.:--+@@@@@@@@@@@@%+#@@@@@@@@@@@@*-:::: \n"+
                        "   :-:::+@@@@@@@@@@@+#*#@@@@@@@@@@*--:::  \n"+
                        "    :-:::-#@@@@@@@@@%-##@@@@@@@@%+--:::   \n"+
                        "     :--:::-*@@@@@@@@:#*@@@@@%*=:-:.:.    \n"+
                        "       ::..:---+*##%%=##%#*+--:::::.      \n"+
                        "          :.:.::--:::-:.:=--:::-:.        \n"+
                        "             .::::....::.--::.            \n"+
                        "                ......... .               \n"+
                        "                                          \n"+
                        "                                          \n"
        );
    }


    public static void mysticKnights(){
        System.out.println(ConsoleColors.GREEN_BOLD +
                        "                                  - .                                                     \n"+
                        "                                 =.-=                                                     \n"+
                        "                                  :+:                          -+-            +#*         \n"+
                        " .+-          +##-     %-    +#+.   *.     -:=.:              :@#@-          =##%:        \n"+
                        "   :=-        @#@*    .*-   :%%%:   :=     +%%#               .%+@+        ..*#%%*=:      \n"+
                        "      ==.   .:=%@#==-. ++ .:-=*=:    =-   .*%@*      -=.   --++#@%#####  .#@%##@%%%@+     \n"+
                        "        --:#@@###%#@@= %=.*++++=*#*  +%*%%%##**#%*   :+@=  +@%=##+-*@#:  :*@@%##%%#:      \n"+
                        "          ++#%###*@*+: %*+#*%##++%-  +%%%%%#*=#@#-   . :=-=%*#*%##+@#*%.  =%%##%%%#.      \n"+
                        "         .##*%%@####%= :+= %@#**==+  .==-#%#%%@+%*   .   :==.=%**+%% +## .##.%%%%#%+      \n"+
                        "          .-+%%%%@@-.     =#++++=.*-    =####%@ #%.  .       +#*%#@% .** *#+*#%@#*=#+=    \n"+
                        "            +%***%%*      *==*+===.:    +%*%%@@-+#: -=      *%+=++%@*:@* %%+#####**::=##+ \n"+
                        "           .#+###+#%.     ++#+*#=-.*:   #*#%#*@*#% :#@=     +*=**%+%@..  =#%%#%#*#*#%%%%%.\n"+
                        "            -:%- =-%      =@% -@@: .    +*@-#*# =:           =:%--.=*   =-=%%%+%%#. .===-:\n"+
                        "            -=#  -+%      +@-  @@.      +@+ +#-             -#+# :=+%   :%###= =@%        \n"+
                        "           :=%:   -#+    .#%   *@=     :*@= #%-             :*%:  .*#.   -@%*: -@#-       \n"+
                        "           -=%    :#@    +@-   -@%      *#* %@:             -*#    =#=   %@@=  :@@-       \n"+
                        "           -#+     +@.   @*     #@      .@# %%              +@=    -%*   =@#    +@.       \n"+
                        "           =@:     :@=  .%+     #@-      *@ %*              *@.    .@%   +@-    =%#+.     \n"+
                        "          =#*.      +*.-#*:     :=*=    .**.-+-            =+=.     -=- -*+               \n"+
                ConsoleColors.RESET
        );
    }

    public static void drache(){
        System.out.println(
                        "                                                                           \n"+
                        "                                                                           \n"+
                        "                                                   .::-=++*##%%%%%*-::     \n"+
                        "                                            :-=+*##%%%%#*###*+==-=+++=-:   \n"+
                        "                                      :-+#%@%#+++***+*****##%%@@@@@@@@%#+:.\n"+
                        "                                 .-+#%%*****#%%**++++****#%@@@@@#++==-::::.\n"+
                        "               .: .-:         :+#%#***#@#*++++*#%@@@@@@@@@@@@#+++=:.       \n"+
                        "             :=::+-        -*%#**#@%##**#%@@@@@@@@@@@@@@@@@%#%@@*-...      \n"+
                        "           .+=-*-       :+#**#@@@@%@@@@@@@@@@@@@@@@@@@@@@@#--==----:       \n"+
                        "          =#=#+.    .=+=+##@@@@%%##**++++==+#%@@@@@@@*:.:-=++-             \n"+
                        "         +%%@%%%%#=.  +@#+@@@%@@@@@@@@@@@@@%#+++#@@@@#====++=:             \n"+
                        "        +#*%%%%%#%@%+: #@=%@@@*+###%#%%%%%%#%@@@%*#%@@@@@@@+::--.          \n"+
                        "     -=*%%#%%%%%%%%@+  +@+%#*@@%=-#%%%%%%%%%%@@@@@@%@+::-====-.            \n"+
                        "    -%%%%#+-:+%%%%@@@: +@+#**#@@@#:#%%%@%%%%@@@@@@@@@*-.                   \n"+
                        "    .:++-.  .#@@@@@@== %##=%++@@@@%-#@@@@@@@@@@@#:.::::                    \n"+
                        "          .+@@@@@@%%..*##=*@-#@@@@@@=%@@@@#:.:-==-.                        \n"+
                        "         =%@@@@@@@+:=%%+=#@@:@@@@@@@%*@@@@@@@%#=                           \n"+
                        "       .#@@@@@@@%##@@#+%@@@#*@@@@@@@@@@@@@*-. .:.                          \n"+
                        "      .#@@@@@@@%#*++++++++**%%*+==++***+-                                  \n"+
                        "      *@%*++++++++++==----:.                                               \n"+
                        "      ::::-:.                                                              \n"+
                        "                                                                           \n"
        );
    }

    public static void elixier(){
        System.out.println(ConsoleColors.PURPLE +
                        "               .                                   \n"+
                        "             .-.                                   \n"+
                        "           .: :  ...                               \n"+
                        "           =. :::.:-:                              \n"+
                        "             -  .:.                                \n"+
                        "            .: :.                                  \n"+
                        "           :. :                                    \n"+
                        "         ::. =      ...:::--                       \n"+
                        "        -.   :-:....  .. ..: ....::.               \n"+
                        "        =.       .:...:.  -=-. .-..+               \n"+
                        "        --..::...      =--..:-.. --. :--=====-=.   \n"+
                        "          ..          = :-::::------=:...    ..=+  \n"+
                        "                       :::*-:      . ..   .....:=+ \n"+
                        "                      .--=:.               *@@#::# \n"+
                        "                   -==-...          .:   :%@%%@-.*.\n"+
                        "                 :+:.  .                +@@@##@- # \n"+
                        "                .#=    :.    ..       .#@@@#*@#::* \n"+
                        "                =+:          :.      +@@@%##@@*.#. \n"+
                        "                .* :.-.          :=*@@@%##%@@%-+=  \n"+
                        "                 :+.:*@@%###**#%@@%@%#%%@@@%@+:#   \n"+
                        "                   ++::*%*@@@@@@@@%#+@@@@@@@*:*.   \n"+
                        "                     =+=:-+#@%@@@@@@#@@@@@@*:*.    \n"+
                        "                       .-==--=**#####@@@#@+:*:     \n"+
                        "                           .==+=---+**##+:.*.      \n"+
                        "                                :-=---:. :+        \n"+
                        "                                      .:-:         \n"+
                ConsoleColors.RESET

        );
    }

    public static void schild(){
        System.out.println(ConsoleColors.BLUE +

                        "              ..:-=++=-:.            \n"+
                        " .........::::--+#%%%#+**##+*******+=\n"+
                        " .::..::::::::::%@@@@%===++**###%%%%@\n"+
                        " ..:  ....::::::#%@@@%-===++**###%#@@\n"+
                        " ..:  ..........#%%%%#:--==++**##%#@@\n"+
                        " ..:. ..........#%%%%%:---=++***###@%\n"+
                        " .::. ..........#%%%%%::--==++**#####\n"+
                        " ..:============%%%%%%=+++***###%%%@+\n"+
                        " ...@@@@@@@@@@@%%%%%%%%%@@@@@@@@@@%@-\n"+
                        "  ..#@@@@@@@@@@%%%%%%%%%@@@@@@@@@%@@.\n"+
                        "  ..-===========%%%%%%+++++**###%#%# \n"+
                        "  .:............#%%%%%::---==++++#+- \n"+
                        "   :.:......:...#@@@@%:--==++****%#  \n"+
                        "   ........:::::#@@@@%--==++****%%=  \n"+
                        "    :.....::::::%@@@@%===+++**##%*   \n"+
                        "     .:::::::::-%@@@@%==++***#**#.   \n"+
                        "     ...:::::---%@@@@%+++***#*%%:    \n"+
                        "      .:.::-----%@@@@%+***##*##:     \n"+
                        "        :..:----%%%%%%++*#**#*.      \n"+
                        "         .:::-==%@@@@@*#**+#=        \n"+
                        "           .::-=%@@@@@***#=.         \n"+
                        "             .:--+##****-            \n"+
                        "               .:-+++-.              \n"+
                ConsoleColors.RESET
        );
    }

    public static void tot(){
        System.out.println(

                        "             :====--===-:           \n"+
                        "          :=-.          .=+:        \n"+
                        "         +=                =+       \n"+
                        "        *-                  -*      \n"+
                        "       -=                    =-     \n"+
                        "       +:  *===+. -= :*===+  :+     \n"+
                        "       *:  *-::*: -+ -*::-*  :*     \n"+
                        "       *:  *:.-*: -+ -+...   :*     \n"+
                        "       *:  +   :- :- :=      :*     \n"+
                        "       *:                    :*     \n"+
                        "       *:    -==========-    :*     \n"+
                        "       *:    -==========-    :*     \n"+
                        "       +:    .::::::::::.    :+     \n"+
                        "       +:    .::.:....::.    :+     \n"+
                        "     *+========================+*   \n"+
                        "   ==*==========================*== \n"+
                        "  .*                              *.\n"+
                        "  .*=----------------------------=*.\n"

        );
    }


    public static void axt(){
        System.out.println(

                        "              :..                            \n"+
                        "             .@#+=:.                         \n"+
                        "            .%@@@@%=:.                       \n"+
                        "         -+*-*@%++*%%--                      \n"+
                        "        =*@@#=:=    .::                      \n"+
                        "        -@%@@#:-:-.                          \n"+
                        "      .*@@@#++*:.: -:                        \n"+
                        "    :*%%%@@.  -+=: ..-:                      \n"+
                        " .:+@@@@@@*     :++- :=-:                    \n"+
                        "  -:.+%@@@@:      .=**:. :.                  \n"+
                        "    ::.:-+#%*:       :*=.:-:                 \n"+
                        "       .....:.=.       -*=-:=:               \n"+
                        "                         -**+-=:             \n"+
                        "                           -++==-:.          \n"+
                        "                             :=*+=-=:.       \n"+
                        "                                :=*+-:+-     \n"+
                        "                                    -+*:.:.  \n"+
                        "                                      :*-.:: \n"+
                        "                                       -*  -=\n"+
                        "                                        #:+**\n"+
                        "                                       *+***=\n"+
                        "                                       *-.:=:\n"+
                        "                                        :::  \n"

        );
    }


    public static void schwert(){
        System.out.println(
                        "                                             \n"+
                        "                                             \n"+
                        "                                        :-:. \n"+
                        "                                      .-@@@*:\n"+
                        "                         ...        :*@=*%#+.\n"+
                        "                         .+=:.    =%@@@@*.   \n"+
                        "                           :-=:.*@@@@@%:     \n"+
                        "                             .--=#@@@=       \n"+
                        "                            ...:+==*.        \n"+
                        "                          ...:=++=-=:.       \n"+
                        "                         ..:=++=:  .==:.     \n"+
                        "                       ..:=++=:      ---     \n"+
                        "                     ...:-+=.                \n"+
                        "                  ....:--:.                  \n"+
                        "                 ...:--:                     \n"+
                        "               ..:=--:                       \n"+
                        "            ....:-+-                         \n"+
                        "          .:.:---:.                          \n"+
                        "        .:::=+=.                             \n"+
                        "       ..:=++-                               \n"+
                        "      .:=+=:                                 \n"+
                        "     :==-.                                   \n"+
                        "    :.                                       \n"+
                        "                                             \n"
        );
    }


    public static void waffen() {
        System.out.println(ConsoleColors.RED +
                        "                                                                              \n"+
                        "                                                                              \n"+
                        "                                                                        .=:   \n"+
                        "                                                                        .=-:  \n"+
                        "      :=-                                                               :- -. \n"+
                        "     =%+%*       --.-  .     ...:.=.                                    -: .+ \n"+
                        "      -**       --  .:    :   .-.  -.      .:                          :: . -.\n"+
                        "      =*#       =    .:::==+:::    .+     =-=+:                 =-+- .-:    ::\n"+
                        "      ==%      .-    ....+**.      .=.  +*++-:*.            .=.:*=+=:.      .=\n"+
                        "     :*+%:     .:    . . -**:     ..=   +#: -++.            :+:-=**=-=.     :-\n"+
                        "   -++-*=++-    -.  . -..--+..-.   :=   -:=   ##=-           ...+:+-  :=:.  --\n"+
                        "  .==-:+:--=.   ::.  :   .:=   -...+.   =-#   ++ ==             -:--   --.  + \n"+
                        "     ::+::       :-::    .:+    -:-:    =-+    =**-            .:.-:   -:..=. \n"+
                        "     :.+--               ..+     .      -:*.     =+-:          .-.-: ..:-=+.  \n"+
                        "     : +::               :.+            : +.     **.-=         .::=.     ..   \n"+
                        "     :.+::               ::+            :.=:      *==# .       ...=.          \n"+
                        "     : +::               :.+            -.=-       :*=-=*: .   ...=           \n"+
                        "     : +::               :.*            : =-    .::=:=:.:-#+   :..=           \n"+
                        "     -.=::               :.=            -..-      *=.:-:=-:*.  :.:+           \n"+
                        "     :.=.-               ::+.           -.:=     .*=-=:-..-*-  :..=           \n"+
                        "     :.+.-               :=*-           -.:+      :+*--:-#=.   :..=           \n"+
                        "     :.=.:               ++#*           - .+      .-:-++-=     :.:=           \n"+
                        "     :.-.-               *+**           = :+:                  : :=           \n"+
                        "     -.-..               *=**           -:-+                   - .=           \n"+
                        "      :=:                +=*+            .:                    .::-           \n"+
                        "       :                 .=-                                                  \n"
                + ConsoleColors.RESET
        );
    }



    public static void infoSpiel() {
        System.out.println("              | Willkommen in Mystic Knights – Die Legende von Tir Na Nog\n" +
                "         /!\\            | Mystic Knights – Die Legende von Tir Na Nog ist eine US-amerikanisch-irische Fantasy-Fernsehserie.\n" +
                "        / ! \\           | Sie wurde 1998 von Saban Entertainment produziert.\n" +
                " /\\    )___(            | Die Handlung der Serie basiert teilweise auf der irischen Mythologie.\n" +
                "(  `.____(_)_________    |\n" +
                "|           __..--\"\"   | Hier spielst Du ein Textbasiertes Fan-Rougegame!\n" +
                "(       _.- |            | Deine Aufgabe ist es so viele Level wie möglich zu schaffen.\n" +
                " \\    ,' | |            | Verlierst Du den Kampf faengt das Spiel von neuem an.\n" +
                "  \\  /   | |            | Du hast jede Runde die Moeglichkeit neue Ritter anzuwerben oder vorhandene aufzuruesten.\n" +
                "   \\(    | |            |\n" +
                "    `     | |            | Die Steuerung erfolgt lediglich ueber eine Zahleneingabe. \n" +
                "          | |            | Liegt die Zahl ueber dem angegebenen Wert, wartet das Spiel auf eine korrektur.\n");
    }

    public static void infoSpielNeu(){
        System.out.println(
                        "                  ....:::::------======.                                                                    \n"+
                        "      -#****######*********************+:::                                                                 \n"+
                        "      *%#************###################%@#                                                                 \n"+
                        "      *#%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@-:.                                                                  \n"+
                        "      *####***#################%%%%%%%%                                                                     \n"+
                        "      *#****************#*########%%%%#            Willkommen in Mystic Knights – Die Legende von Tir Na Nog\n"+
                        "      *#**********************######%%#              Mystic Knights – Die Legende von Tir Na Nog ist eine   \n"+
                        "      *#*************************####%%                  US-amerikanisch-irische Fantasy-Fernsehserie.      \n"+
                        "      +#*****           **********###%*                Sie wurde 1998 von Saban Entertainment produziert    \n"+
                        "      *#******+++++++++++++*********###            Die Handlung der Serie basiert teilweise auf der irischen\n"+
                        "      +##****+                 *****##+                                   Mythologie.                       \n"+
                        "      +#**+++++===========+++++****+**=                Hier spielst Du ein Textbasiertes Fan-Rougegame!     \n"+
                        "      +##***++            ***********#+               Deine Aufgabe ist es so viele Level wie möglich zu    \n"+
                        "      *##*******++++++++++++*********#*                                    schaffen.                        \n"+
                        "      *#####****              *******##              Verlierst Du den Kampf faengt das Spiel von neuem an.  \n"+
                        "      *########**********************##                 Du hast jede Runde die Moeglichkeit neue Ritter     \n"+
                        "      #%%######                 *****#*                    anzuwerben oder vorhandene aufzuruesten.         \n"+
                        "      *%%%#######********+************+            Die Steuerung erfolgt lediglich ueber eine Zahleneingabe.\n"+
                        "      #%%%%%################*******##**                                                                     \n"+
                        "      #%%%%%%%%%%%##################***                                                                     \n"+
                        "  #%#*##########################****##*                                                                     \n"+
                        "  =+*****+++++***********************%+                                                                     \n"+
                        "    .+#%%%##########******++++===---:.                                                                      \n"
        );
    }

}

