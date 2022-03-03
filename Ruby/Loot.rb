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
    def initialize (the_supplies, the_weapons, the_shields, the_hangars, the_medals)
        @nSupplies = the_supplies
        @nWeapons  = the_weapons
        @nShields  = the_shields
        @nHangars  = the_hangars
        @nMedals   = the_medals
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
