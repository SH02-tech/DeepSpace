#encoding:utf-8

module Deepspace

    require_relative "Dice.rb"
    require_relative "BetaPowerEfficientSpaceStationToUI.rb"


    class BetaPowerEfficientSpaceStation < PowerEfficientSpaceStation

        @@EXTRAEFFICIENCY = 1.2

        def self.newCopy(station)
            super(station)
        end

        def getUIversion
            BetaPowerEfficientSpaceStationToUI.new(self)
        end

        def fire
            @dice = Dice.new 
            if @dice.extraEfficiency
                super*@@EXTRAEFFICIENCY
            else
                super
            end
        end
        
    end

end # Deepspace
