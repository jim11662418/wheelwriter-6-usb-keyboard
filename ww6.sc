#
## Wheelwriter 6 Series II Matrix (US English)
#
# Because the keyboard is labeled for use on a typewriter, some key remapping is necessary for use with a PC.
#
## Functionality Differences:
# The 6 key has a ¢ symbol on top, but it will output the standard Caret (^) symbol when shifted.
# The key above the Tab key is the ° and ± sign, but it acts as the (` and ~) Grave Accent key.
# The right bracket key (]) produces the right curly brace (}) symbol when shifted.
# The ½ key produces the left bracket ([) and left curly brace ({) symbols.
#
## Keys on the spacebar Row:
# The Code key is used as the Ctrl key.
# The Correction key [<X]] is used as the Alt key.
#
## Keys on the left side 10 key vertical block:
# The Margin Release [Mar Rel] key is used the Escape key.
# The Left and Right Margin [LMar and RMar} keys are used as the left and right Windows keys [LGUI and RGUI], respectively.
# The Tab Clear [T Clr] key is used as a function modifier (Fn) key (similar to a Shift or Ctrl or Alt key).
#   [T Clr]+[1] = F1
#   [T Clr]+[2] = F2
#   [T Clr]+[3] = F3
#   [T Clr]+[4] = F4
#   [T Clr]+[5] = F5
#   [T Clr]+[6] = F6
#   [T Clr]+[7] = F7
#   [T Clr]+[8] = F8
#   [T Clr]+[9] = F9
#   [T Clr]+[0] = F10
#   [T Clr]+[Minus/Underscore] = F11
#   [T Clr]+[Equal/Plus] = F12
#   [T Clr]+[Backspace] = Delete (for the Ctrl,Alt,Del key combo, press Code,Correction,T Clr and Backspace simultaneously)
#   [T Clr]+[Paper Up] = Home
#   [T Clr]+[Paper Down] = End
#   [T Clr]+[P] = Print Screen
#   [T Clr]+[I] = Insert
#   [T Clr]+[W] = Cursor Up
#   [T Clr]+[A] = Cursor Left
#   [T Clr]+[S] = Cursor Down
#   [T Clr]+[D] = Cursor Right
#
## Keys on the right side 5-key vertical block:
# The Micro Up and Micro Down keys are used as  the Up and Down arrow keys, respectively.
# The Paper Up and Paper Down keys are used as the PgUp and PgDn keys, respectively.
# 
# Teensy Connections:
# Strobe pins, left side 16 pin connector (pin 1 is the leftmost pin as pictured from the front of the keyboard)
# Connector : Teensy
#         1 : NC
#         2 : NC
#         3 : NC
#         4 : B2
#         5 : B3
#         6 : B7
#         7 : D0
#         8 : D1
#         9 : D2
#        10 : D3
#        11 : C6
#        12 : B0
#        13 : B4
#        14 : D7
#        15 : E6
#        16 : D4
# 
# Sense pins, right side 16 pin connector (pin 1 is the leftmost pin as pictured from the front of the keyboard)
#         1 : F0
#         2 : F1
#         3 : F4
#         4 : F5
#         5 : F6
#         6 : F7
#         7 : B6
#         8 : B5
#         9 : NC
#        10 : NC
#        11 : NC
#        12 : NC
#        13 : NC
#        14 : NC
#        15 : NC
#        16 : NC

led caps -PD5     # connected to the Shift Lock LED on the keyboard for the Caps Lock indication

matrix
   scanrate 1
   debounce 5
   blocking 0
   
   #             PF0         PF1          PF4          PF5          PF6          PF7          PB6           PB5  
   #      PB2    ----        ----         ----         ----         ----         ----         ----          Code
   #      PB3    T Clr       Del          Advnc        Store        LMar         Play         Micro Down    Space   
   #      PB7    Reloc       T Sel        Mar Rel      ----         Tab          RMar         Lock          Correction   
   #      PD0    ----        ----         ----         ----         ----         ----         ----          Shift
   #      PD1    ----        A            ±            1            Q            ----         Z             ----      
   #      PD2    ----        S            ----         2            W            ----         X             ----      
   #      PD3    ----        D            ----         3            E            ----         C             ----        
   #      PC6    G           F            5            4            R            T            V             B  
   #      PB0    H           J            6            7            U            Y            M             N  
   #      PB4    ----        K            =            8            I            ]            ,             ----        
   #      PD7    ----        L            ----         9            O            ----         .             ----      
   #      PE6    '           ;            -            0            P            ½            ----          /  
   #      PD4    ----        Micro Up     Backspace    Paper Up     Paper Down   ----         C Ret        Line Space           
   

   sense        PF0          PF1          PF4          PF5          PF6          PF7          PB6           PB5  
   strobe PB2   UNASSIGNED   UNASSIGNED   UNASSIGNED   UNASSIGNED   UNASSIGNED   UNASSIGNED   UNASSIGNED    LCTRL 
   strobe PB3   FN2          UNASSIGNED   UNASSIGNED   UNASSIGNED   LGUI         UNASSIGNED   DOWN          SPACE 
   strobe PB7   UNASSIGNED   UNASSIGNED   ESC          UNASSIGNED   TAB          RGUI         CAPS_LOCK     LALT  
   strobe PD0   UNASSIGNED   UNASSIGNED   UNASSIGNED   UNASSIGNED   UNASSIGNED   UNASSIGNED   UNASSIGNED    LSHIFT
   strobe PD1   UNASSIGNED   A            BACK_QUOTE   1            Q            UNASSIGNED   Z             UNASSIGNED  
   strobe PD2   UNASSIGNED   S            UNASSIGNED   2            W            UNASSIGNED   X             UNASSIGNED  
   strobe PD3   UNASSIGNED   D            UNASSIGNED   3            E            UNASSIGNED   C             UNASSIGNED  
   strobe PC6   G            F            5            4            R            T            V             B  
   strobe PB0   H            J            6            7            U            Y            M             N  
   strobe PB4   UNASSIGNED   K            EQUAL        8            I            RIGHT_BRACE  COMMA         UNASSIGNED  
   strobe PD7   UNASSIGNED   L            UNASSIGNED   9            O            UNASSIGNED   PERIOD        UNASSIGNED
   strobe PE6   QUOTE        SEMICOLON    MINUS        0            P            LEFT_BRACE   UNASSIGNED    SLASH
   strobe PD4   UNASSIGNED   UP           BACKSPACE    PAGE_UP      PAGE_DOWN    UNASSIGNED   ENTER         UNASSIGNED     

end

macroblock
# macros (if any) go here
endblock

# [T Clr] at the bottom of the left 5-key vertical block is used as Function key
layerblock
   FN2 2
endblock

# Function Modifier Layer
remapblock
   layer 2 # when the T Clr key is held down...
   W UP
   A LEFT
   S DOWN
   D RIGHT
   
   BACKSPACE DELETE
   PAGE_UP HOME
   PAGE_DOWN END
   P PRINTSCREEN
   I INSERT
   
   1 F1
   2 F2
   3 F3
   4 F4
   5 F5
   6 F6
   7 F7
   8 F8
   9 F9
   0 F10
   MINUS F11
   EQUAL F12
endblock