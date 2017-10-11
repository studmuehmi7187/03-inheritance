```
@startuml
enum GenusSpecies {

    LION,
    GAZELLE,
    FLAMINGO

	-readableType: String
    -type: String

    +String getReadableType()
    +String getType()
}

class Animal {
	-sleep: int
    -awake: int
    -digest: int

    -currentState: State

    -name: String
    -genusSpecies: GenusSpecies
    -devours: GenusSpecies[]
    -collectionAmount: int
    
    +void feed()
    +void tick()
    +int collect()
    +boolean devours(Animal other)

    +boolean isAsleep()
    +boolean isPlayful()
    +boolean isHungry()
    +boolean isDigesting()
    +boolean isDead()

    +int getSleep()
    +int getDigest()
    +int getAwake()
    +String getName()
}

abstract class State {
	#{static}logger: Logger
    #animal: Animal
    -t: int
    -duration: int
    State tick()
    abstract State successor()
}

class DigestingState {
}

class HungryState {
    State feed()
}

class PlayfulState {
}

class SleepingState {
}

class DeathState {
}

State *-- Animal : current state
GenusSpecies *-- Animal: genus species
GenusSpecies "n" *-- Animal: devours

State <|-- DigestingState
State <|-- HungryState
State <|-- PlayfulState
State <|-- SleepingState
State <|-- DeathState
@enduml