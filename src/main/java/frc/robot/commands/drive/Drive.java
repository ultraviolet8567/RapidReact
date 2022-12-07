// Description:
// Operates the robot's drivetrain based on the mode
// Single stick - robot moves as if the left joystick is an arcade joystick
// Split control - left joystick controls forward/backward velocity, right joystick controls rotation
// Tank drive - each joystick controls one side of the drivetrain


package frc.robot.commands.drive;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;


public class Drive extends CommandBase {
    private Drivetrain m_drivetrain;
    protected XboxController xbox;
    private Drive drivetype;
    
    public Drive(Drivetrain subsystem) {
        m_drivetrain = subsystem;
        addRequirements(m_drivetrain);
        if (subsystem.isTankDrive()) {
            drivetype = new Tank(subsystem);
        }
        else if (subsystem.isSingleStickDrive()) {
            drivetype = new SingleStick(subsystem);
        }
        else {
            drivetype = new SplitControl(subsystem);
        }
    }

    public Drive() {}

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        xbox = RobotContainer.getInstance().getXboxController();
        drivetype.initialize();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
       drivetype.execute();
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        drivetype.end(interrupted);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;
    }

    // Exponential modifier function: 0.1 * Math.pow(3.5, 2 * input) - 0.1
}