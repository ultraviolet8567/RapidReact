// Description:
// Manually sets the flywheel speed to the velocity
// required for a fender shot (at the base of the hub)


package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class ShootDistance extends CommandBase{
    private final Shooter m_shooter;

    public ShootDistance(Shooter subsystem) {
        m_shooter = subsystem;
        addRequirements(m_shooter);
    }
    
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        m_shooter.setMode("Fender");
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;
    }
}
