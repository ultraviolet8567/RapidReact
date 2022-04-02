package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;


public class AlignShooter extends CommandBase {
    private final Drivetrain m_drivetrain;
    private final Limelight m_limelight;
    private final Shooter m_shooter;
    private Boolean aligned;

    public AlignShooter(Drivetrain drivetrain, Limelight limelight, Shooter shooter) {
        m_drivetrain = drivetrain;
        m_limelight = limelight;
        m_shooter = shooter;
        addRequirements(m_drivetrain);
        addRequirements(m_limelight);
        addRequirements(m_shooter);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        aligned = false;
        m_drivetrain.stopMotors();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        if (m_limelight.hOffset == 0) {
            m_drivetrain.stopMotors();
            aligned = true;
        }
        else if (m_limelight.hOffset > 0) {
            m_drivetrain.getDifferentialDrive().arcadeDrive(0.1, 1);
        }
        else if (m_limelight.hOffset < 0) {
            m_drivetrain.getDifferentialDrive().arcadeDrive(0.1, -1);
        }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        // Double[] speeds = m_limelight.flywheelSpeeds();
        // m_shooter.runBigFlywheel(speeds[0], ControlType.kVelocity);
        // m_shooter.runSmallFlywheel(speeds[1], ControlType.kVelocity);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return aligned;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;
    }
}
