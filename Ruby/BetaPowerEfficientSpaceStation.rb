#encoding:utf-8

module Deepspace

    require_relative "Dice.rb"

    class BetaPowerEfficientSpaceStation < PowerEfficientSpaceStation

        @@EXTRAEFFICIENCY = 1.2

        def self.newCopy(station)
            super(station)
            dice = Dice.new 
        end

        def fire
            if dice.extraEfficiency
                super*@@EXTRAEFFICIENCY
            else
                super
        end
        
    end

end # Deepspace
