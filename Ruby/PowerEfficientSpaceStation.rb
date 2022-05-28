#encoding:utf-8

module Deepspace

    require_relative "PowerEfficientSpaceStationToUI.rb"
    require_relative "SpaceStation.rb"

    class PowerEfficientSpaceStation < SpaceStation 

        @@EFFICIENCYFACTOR = 1.1

        # Override
        def initialize(n, supplies)
            super
        end

        # Override
        def self.newCopy(station)
            super(station)
        end

        # Override
        def getUIversion
            PowerEfficientSpaceStationToUI.new(self)
        end

        # Override
        def fire
            super*@@EFFICIENCYFACTOR
        end

        # Override
        def protection
            super*@@EFFICIENCYFACTOR
        end

        # Override
        def setLoot(loot)
            super(loot)
            if loot.efficient
                Transformation::GETEFFICIENT
            else 
                Transformation::NOTRANSFORM
            end
        end

    end # PowerEfficientSpaceStation

end # Deepspace

if $0 == __FILE__ then
    supplies_package = Deepspace::SuppliesPackage.new(3,4,5)
    space_station = Deepspace::SpaceStation.new("Nombre", supplies_package)
    l = Deepspace::Loot.new(2,2,2,2,2, true, true)

    puts space_station.to_s

    efficient = Deepspace::PowerEfficientSpaceStation.newCopy(space_station)
    puts space_station.fire
    puts efficient.fire
    puts efficient.setLoot(l)
end