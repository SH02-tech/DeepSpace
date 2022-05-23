#encoding:utf-8
require_relative 'SpaceCity'

puts '----------------------------------------------------'
puts 'Constructor and Collaborators'
puts '----------------------------------------------------'

supplies_package = Deepspace::SuppliesPackage.new(3,4,5)
loot = Deepspace::Loot.new(1,1,1,1,1, true, true)

s1 = Deepspace::SpaceStation.new("Base", supplies_package)
s2 = Deepspace::SpaceStation.new("Colaborador 1", supplies_package)
s3 = Deepspace::SpaceStation.new("Colaborador 2", supplies_package)

sc = Deepspace::SpaceCity.new(s1, [s2, s3])

puts "INSPECT: \n" + sc.inspect
puts "COLLABORATORS: \n" + sc.collaborators.inspect

puts '----------------------------------------------------'
puts 'Fire and protection'
puts '----------------------------------------------------'

puts "FIRE: " + sc.fire.to_s
puts "PROTECTION: " + sc.protection.to_s

puts '----------------------------------------------------'
puts 'Set Loot'
puts '----------------------------------------------------'

puts sc.setLoot(loot)