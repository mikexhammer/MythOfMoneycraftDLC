package ascii_art;

import helper.Ausgabe;
import helper.ConsoleColors;
import logik.Spiel;

/**
 * Klasse für die Ausgabe von ASCII-Grafiken
 */
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

    public static void kampfStart(){
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

    public static void maeve(){
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
        System.out.println(
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
                        "          =#*.      +*.-#*:     :=*=    .**.-+-            =+=.     -=- -*+               \n"

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



    public static void infoSpielDeutsch(){
        System.out.println(
                        ConsoleColors.YELLOW + "                  ....:::::------======.   "+ConsoleColors.RESET +"                                                                 \n"+
                        ConsoleColors.YELLOW + "      -#****######*********************+:::"+ConsoleColors.RESET +"                                                                 \n"+
                        ConsoleColors.YELLOW + "      *%#************###################%@#"+ConsoleColors.RESET +"                                                                 \n"+
                        ConsoleColors.YELLOW + "      *#%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@-:. "+ConsoleColors.RESET +"                                                                 \n"+
                        ConsoleColors.YELLOW + "      *####***#################%%%%%%%%    "+ConsoleColors.RESET +"                                                                 \n"+
                        ConsoleColors.YELLOW + "      *#****************#*########%%%%#    "+ConsoleColors.RESET +"        Willkommen in Mystic Knights – Die Legende von Tir Na Nog\n"+
                        ConsoleColors.YELLOW + "      *#**********************######%%#    "+ConsoleColors.RESET +"          Mystic Knights – Die Legende von Tir Na Nog ist eine   \n"+
                        ConsoleColors.YELLOW + "      *#*************************####%%    "+ConsoleColors.RESET +"              US-amerikanisch-irische Fantasy-Fernsehserie.      \n"+
                        ConsoleColors.YELLOW + "      +#*****           **********###%*    "+ConsoleColors.RESET +"            Sie wurde 1998 von Saban Entertainment produziert    \n"+
                        ConsoleColors.YELLOW + "      *#******+++++++++++++*********###    "+ConsoleColors.RESET +"        Die Handlung der Serie basiert teilweise auf der irischen\n"+
                        ConsoleColors.YELLOW + "      +##****+                 *****##+    "+ConsoleColors.RESET +"                               Mythologie.                       \n"+
                        ConsoleColors.YELLOW + "      +#**+++++===========+++++****+**=    "+ConsoleColors.RESET +"            Hier spielst Du ein Textbasiertes Fan-Rougegame!     \n"+
                        ConsoleColors.YELLOW + "      +##***++            ***********#+    "+ConsoleColors.RESET +"           Deine Aufgabe ist es so viele Level wie möglich zu    \n"+
                        ConsoleColors.YELLOW + "      *##*******++++++++++++*********#*    "+ConsoleColors.RESET +"                                schaffen.                        \n"+
                        ConsoleColors.YELLOW + "      *#####****              *******##    "+ConsoleColors.RESET +"          Verlierst Du den Kampf faengt das Spiel von neuem an.  \n"+
                        ConsoleColors.YELLOW + "      *########**********************##    "+ConsoleColors.RESET +"             Du hast jede Runde die Moeglichkeit neue Ritter     \n"+
                        ConsoleColors.YELLOW + "      #%%######                 *****#*    "+ConsoleColors.RESET +"                anzuwerben oder vorhandene aufzuruesten.         \n"+
                        ConsoleColors.YELLOW + "      *%%%#######********+************+    "+ConsoleColors.RESET +"        Die Steuerung erfolgt lediglich ueber eine Zahleneingabe.\n"+
                        ConsoleColors.YELLOW + "      #%%%%%################*******##**    "+ConsoleColors.RESET +"                                                                 \n"+
                        ConsoleColors.YELLOW + "      #%%%%%%%%%%%##################***    "+ConsoleColors.RESET +"                                                                 \n"+
                        ConsoleColors.YELLOW + "  #%#*##########################****##*    "+ConsoleColors.RESET +"                                                                 \n"+
                        ConsoleColors.YELLOW + "  =+*****+++++***********************%+    "+ConsoleColors.RESET +"                                                                 \n"+
                        ConsoleColors.YELLOW + "    .+#%%%##########******++++===---:.     "+ConsoleColors.RESET +"                                                                 \n"
        );
    }

    public static void infoSpielEnglisch() {
        System.out.println(
                        ConsoleColors.YELLOW + "                  ....:::::------======.   "+ConsoleColors.RESET +"                                                                \n"+
                        ConsoleColors.YELLOW + "      -#****######*********************+:::"+ConsoleColors.RESET +"                                                                \n"+
                        ConsoleColors.YELLOW + "      *%#************###################%@#"+ConsoleColors.RESET +"                                                                \n"+
                        ConsoleColors.YELLOW + "      *#%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@-:. "+ConsoleColors.RESET +"                                                                \n"+
                        ConsoleColors.YELLOW + "      *####***#################%%%%%%%%    "+ConsoleColors.RESET +"                                                                \n"+
                        ConsoleColors.YELLOW + "      *#****************#*########%%%%#    "+ConsoleColors.RESET +"         Welcome to Mystic Knights - The Legend of Tir Na Nog   \n"+
                        ConsoleColors.YELLOW + "      *#**********************######%%#    "+ConsoleColors.RESET +"            Mystic Knights - The Legend of Tir Na Nog is an     \n"+
                        ConsoleColors.YELLOW + "      *#*************************####%%    "+ConsoleColors.RESET +"               American-Irish fantasy television series.        \n"+
                        ConsoleColors.YELLOW + "      +#*****           **********###%*    "+ConsoleColors.RESET +"            It was produced in 1998 by Saban Entertainment      \n"+
                        ConsoleColors.YELLOW + "      *#******+++++++++++++*********###    "+ConsoleColors.RESET +"            The plot of the series is partly based on Irish     \n"+
                        ConsoleColors.YELLOW + "      +##****+                 *****##+    "+ConsoleColors.RESET +"                              mythology.                        \n"+
                        ConsoleColors.YELLOW + "      +#**+++++===========+++++****+**=    "+ConsoleColors.RESET +"              Here you play a text based fan rouge game!        \n"+
                        ConsoleColors.YELLOW + "      +##***++            ***********#+    "+ConsoleColors.RESET +"         Your task is to complete as many levels as possible.   \n"+
                        ConsoleColors.YELLOW + "      *##*******++++++++++++*********#*    "+ConsoleColors.RESET +"             If you lose the fight, the game starts again.      \n"+
                        ConsoleColors.YELLOW + "      *#####****              *******##    "+ConsoleColors.RESET +"          You have every round the possibility to recruit new   \n"+
                        ConsoleColors.YELLOW + "      *########**********************##    "+ConsoleColors.RESET +"                 knights or to upgrade existing ones.           \n"+
                        ConsoleColors.YELLOW + "      #%%######                 *****#*    "+ConsoleColors.RESET +"          The game is controlled only by entering a number.    \n"+
                        ConsoleColors.YELLOW + "      *%%%#######********+************+    "+ConsoleColors.RESET +"       If the number is above the given value, the game waits  \n"+
                        ConsoleColors.YELLOW + "      #%%%%%################*******##**    "+ConsoleColors.RESET +"                          for a correction.                    \n"+
                        ConsoleColors.YELLOW + "      #%%%%%%%%%%%##################***    "+ConsoleColors.RESET +"                                                               \n"+
                        ConsoleColors.YELLOW + "  #%#*##########################****##*    "+ConsoleColors.RESET +"                                                               \n"+
                        ConsoleColors.YELLOW + "  =+*****+++++***********************%+    "+ConsoleColors.RESET +"                                                               \n"+
                        ConsoleColors.YELLOW + "    .+#%%%##########******++++===---:.     "+ConsoleColors.RESET +"                                                               \n"
        );
    }

}

