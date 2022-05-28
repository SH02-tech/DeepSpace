#encoding:utf-8

module Deepspace

    require_relative "PowerEfficientSpaceStationToUI.rb"

    class PowerEfficientSpaceStation < SpaceStation 

        @@EFFICIENCYFACTOR = 1.1

        def self.newCopy(station)
            super(station)
        end

        def getUIversion
            PowerEfficientSpaceStationToUI.new(self)
        end

        def fire
            super*@@EFFICIENCYFACTOR
        end

        def protection
            super*@@EFFICIENCYFACTOR
        end

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
