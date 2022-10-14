// Description:
// Changes the direction of the collection motors
// used to eject a ball if necessary


package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Collection;


public class ReverseCollection extends CommandBase {
    private final Collection m_collection;
    
    public ReverseCollection(Collection subsystem) {
        m_collection = subsystem;
        addRequirements(m_collection);
    }
    
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        m_collection.toggleDirection();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {}

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
