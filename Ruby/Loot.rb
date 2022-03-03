#encoding:utf-8

# +-------------------------------------------------------------------+ #
# | DEEPSPACE (Ruby)                                                  | #
# | Authors: Shao Jie Hu Chen and Mario Megías Mateo                  | #
# +-------------------------------------------------------------------+ #
# | Class that represents the loot obtain when a space station        | #  
# | defeats a enemy ship.                                             | #
# +-------------------------------------------------------------------+ #

class Loot

    # Constructor 
    def initialize (supplies, weapons, shields, hangars, medals)
        @nSupplies = supplies
        @nWeapons  = weapons
        @nShields  = shields
        @nHangars  = hangars
        @nMedals   = medals
    end

    # Gets methods

    def nSupplies
        @nSupplies
    end
    
    def nWeapons
        @nWeapons
    end

    def nShields
        @nShields
    end
    
    def nHangars
        @nHangars
    end
    
    def nMedals
        @nMedals
    end

end
