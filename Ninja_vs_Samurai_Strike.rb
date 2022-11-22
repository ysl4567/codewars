class Warrior
  attr_reader :name
  attr_accessor :health

  def initialize(name)
    @name = name
    @health = 100
  end

  def strike(enemy,swings)
    enemy.health = [0, enemy.health - (swings * 10)].max
  end
end
