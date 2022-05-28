#encoding:utf-8

module Deepspace

    require_relative "Dice.rb"
    require_relative "BetaPowerEfficientSpaceStationToUI.rb"
    require_relative "PowerEfficientSpaceStation.rb"


    class BetaPowerEfficientSpaceStation < PowerEfficientSpaceStation

        @@EXTRAEFFICIENCY = 1.2

        # Override
        def initialize(n, s)
            super
            @dice = Dice.new
        end

        # Override
        def self.newCopy(station)
            super(station)
        end

        # Override
        def getUIversion
            BetaPowerEfficientSpaceStationToUI.new(self)
        end

        # Override
        def fire
            if @dice.extraEfficiency
                super*@@EXTRAEFFICIENCY
            else
                super
            end
        end
        
    end

end # Deepspace

if $0 == __FILE__ then
    supplies_package = Deepspace::SuppliesPackage.new(3,4,5)
    space_station = Deepspace::SpaceStation.new("Nombre", supplies_package)

    puts space_station.to_s

    beta_power = Deepspace::BetaPowerEfficientSpaceStation.newCopy(space_station)

    puts space_station.fire
    puts beta_power.fire
end