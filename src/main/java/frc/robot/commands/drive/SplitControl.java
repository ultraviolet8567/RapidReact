// Description:
// Operates the robot's drivetrain based on the mode
// Single stick - robot moves as if the left joystick is an arcade joystick
// Split control - left joystick controls forward/backward velocity, right joystick controls rotation
// Tank drive - each joystick controls one side of the drivetrain


package frc.robot.commands.drive;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.Drivetrain;


class SplitControl extends Drive {
    private final Drivetrain m_drivetrain;
    private XboxController xbox;
    
    public SplitControl(Drivetrain subsystem) {
        m_drivetrain = subsystem;
        addRequirements(m_drivetrain);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        xbox = super.xbox;
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_drivetrain.getDifferentialDrive().arcadeDrive(
                -xbox.getLeftY(),
                xbox.getRightX(),
                true);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
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