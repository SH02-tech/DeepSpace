#encoding:utf-8

# +-------------------------------------------------------------------+ #
# | DEEPSPACE (Ruby)                                                  | #
# | Authors: Shao Jie Hu Chen and Mario Megías Mateo                  | #
# +-------------------------------------------------------------------+ #
# | Class that represents the loot obtain when a space station        | #  
# | defeats a enemy ship.                                             | #
# +-------------------------------------------------------------------+ #

module Deepspace

class Loot

    # Constructor 
    def initialize(the_supplies, the_weapons, the_shields, the_hangars, the_medals)
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

    def getUIversion
        return LootToUI.new(self)
    end

    # to_s method
    def to_s
        "Loot => Supplies: #{nSupplies}, \tWeapons: #{nWeapons}, " + \
        "\tShields: #{nShields}, \tHangars: #{nHangars}, \tMedals: #{nMedals}."
    end

end

    ### TEST PROGRAM    
    # l = Loot.new(10,5,4,8,10)
    # puts l.to_s

end # end of Deepspace