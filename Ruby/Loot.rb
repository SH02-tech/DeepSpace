#encoding:utf-8

# +-------------------------------------------------------------------+ #
# | DEEPSPACE (Ruby)                                                  | #
# | Authors: Shao Jie Hu Chen and Mario Megías Mateo                  | #
# +-------------------------------------------------------------------+ #
# | Class that represents the loot obtain when a space station        | #  
# | defeats a enemy ship.                                             | #
# +-------------------------------------------------------------------+ #

module Deepspace

    require_relative "LootToUI.rb"

    class Loot

        # Constructor 
        def initialize(the_supplies, the_weapons, the_shields, the_hangars, the_medals)
            @nSupplies = the_supplies
            @nWeapons  = the_weapons
            @nShields  = the_shields
            @nHangars  = the_hangars
            @nMedals   = the_medals
        end

        # Getters
        attr_reader :nSupplies, :nWeapons, :nShields, :nHangars, :nMedals 

        def getUIversion
            return LootToUI.new(self)
        end

        # to_s method
        def to_s
            "[supplies: #{nSupplies}; weapons: #{nWeapons}; shields: #{nShields}; hangars: #{nHangars}; medals: #{nMedals}]"
        end

    end # end of class Loot

end # end of Deepspace