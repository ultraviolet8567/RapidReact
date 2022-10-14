# ET Bike Home
Robot code for FRC Team 8567 in the 2022 Rapid React season

## Subsystems
### Drivetrain
Components:
* Left motor group: Operates the left side of the robot
* Right motor group: Operates the right side of the robot

Commands:
* __Drive__ (default)


### Collection
Components:
* Intake: Picks up balls from the field
* Conveyor: Moves balls up into the storage and brings them to the shooter flywheels
* Top photoelectric sensor: Detects when a ball has reached storage height
* Bottom photoelectric sensor: Detects when a ball has reached the conveyor

Commands:
* __Collect__
  * Extends intake and runs intake and conveyor motors. Once the top photoelectric sensor detects a ball has reached storage position, it stops the conveyor. The intake stops and retracts when the operator presses the button again.
* __ReverseCollection__
  * Reverses the direction the collection motors spin in
  

### Shooter
Components:
* Big flywheel: Gives the ball speed
* Small flywheel: Modifies the trajectory of the ball

Commands:
* __Shoot__
  * Runs the conveyor to move the ball up the storage to the flywheels
* __Shoot Fender__
  * Changes the flywheel velocities to those necessary for a fender shot
* __Shoot Toggle__
  * Toggles the flywheel velocities between off, fender, lower hub, calibration, and limelight calculation shot


### Limelight
Components:
* Limelight 2

Commands
* __AlignShooter__: Uses the Limelight to orient the robot toward the upper hub and calculates the velocities needed to score the ball based on the target's y-value in the Limelight feed


### Autonomous
Modes:
* "Drive Out": Just drive out of the tarmac to get the 2 points
* "One Ball": Shoot our pre-loaded ball from the starting position, then exit the tarmac
* "Two Ball": Pick up the ball right in front of us, then move back to the upper hub and shoot both. Finally, exit the tarmac once more


## Ports
### CAN IDs
* 1 - Big flywheel
* 2 - Small flywheel
* 3 - Left front wheel
* 4 - Right back wheel
* 5 - Left back wheel
* 6 - Right front wheel
* 7 - Intake
* 8 - Conveyor
* 9 - Left hanger
* 10 - Right hanger

### Digital I/O
* 0 - Top photoelectric detector
* 1 - Bottom photoelectric detector

### Computer Ports
* 0 - Xbox controller 1, operates drivetrain, collection, and shooting
* 1 - Xbox controller 2, operates hanger
