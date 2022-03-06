package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.SparkMaxPIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class Shooter extends SubsystemBase {

    private CANSparkMax bigFlywheel;
    private CANSparkMax smallFlywheel;

    public Shooter() {
        bigFlywheel = new CANSparkMax(4, MotorType.kBrushless);
        bigFlywheel.setInverted(false);

        smallFlywheel = new CANSparkMax(10, MotorType.kBrushless);
        smallFlywheel.setInverted(false);
    }

    // This method will be called once per scheduler run
    @Override
    public void periodic() {
        SmartDashboard.putNumber("Big flywheel speed", bigFlywheel.getEncoder().getVelocity());
        SmartDashboard.putNumber("Small flywheel speed", smallFlywheel.getEncoder().getVelocity());
        SmartDashboard.putNumber("Big flywheel set speed", Constants.bigFlywheelSpeed);
        SmartDashboard.putNumber("Small flywheel set speed", Constants.smallFlywheelSpeed);
    }

    // This method will be called once per scheduler run when in simulation
    @Override
    public void simulationPeriodic() {
    }

    // Put methods for controlling this subsystem here. Call these from Commands.

    // Sets a parameter (type) of shooterMC1(? no idea what that stands for) to the given value (setPoint)
    // e.g. possible parameters are ControlType.kDutyCycle, ControlType.kPosition, ControlType.kVelocity, and ControlType.kVoltage
    public void runBigFlywheel(double setPoint, ControlType type) {
        SparkMaxPIDController pid_controller = RobotContainer.getDefaultPIDController(bigFlywheel);
        pid_controller.setReference(setPoint, type);
    }

    // Sets a parameter (type) of shooterMC2(again, no idea) to the given value (setPoint)
    // e.g. possible parameters are ControlType.kDutyCycle, ControlType.kPosition, ControlType.kVelocity, and ControlType.kVoltage
    public void runSmallFlywheel(double setPoint, ControlType type) {
        SparkMaxPIDController pid_controller = RobotContainer.getDefaultPIDController(smallFlywheel);
        pid_controller.setReference(setPoint, type);
    }
}