// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: RobotContainer.

package frc.robot;

import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxPIDController;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

    private static RobotContainer m_robotContainer = new RobotContainer();

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    // The robot's subsystems
    public final Hanger m_hanger = new Hanger();
    public final Storage m_storage = new Storage();
    public final Collection m_collection = new Collection();
    public final Shooter m_shooter = new Shooter();
    public final Drivetrain m_drivetrain = new Drivetrain();

    // Joysticks
    private final XboxController xboxController = new XboxController(0);
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // A chooser for autonomous commands
    SendableChooser<Command> m_chooser = new SendableChooser<>();

    /**
     * The container for the robot.  Contains subsystems, OI devices, and commands.
    */
    private RobotContainer() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("Drive", new Drive( m_drivetrain ));
        SmartDashboard.putData("DriveToggle", new DriveToggle( m_drivetrain ));
        SmartDashboard.putData("Intake", new Intake( m_collection ));
        SmartDashboard.putData("Shoot", new Shoot( m_shooter ));
        SmartDashboard.putData("ExtendHanger", new ExtendHanger( m_hanger ));
        SmartDashboard.putData("RetractHanger", new RetractHanger( m_hanger ));
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD

        // Configure the button bindings
        configureButtonBindings();

        // Configure default commands
        m_drivetrain.setDefaultCommand(new Drive(m_drivetrain));
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND

        // Configure autonomous sendable chooser
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
        m_chooser.setDefaultOption("Autonomous Command", new AutonomousCommand());
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

        SmartDashboard.putData("Auto Mode", m_chooser);
    }

    public static RobotContainer getInstance() {
        return m_robotContainer;
    }

    public static SparkMaxPIDController getDefaultPIDController(CANSparkMax motor) {
        SparkMaxPIDController pid_controller = motor.getPIDController();

        pid_controller.setP(6e-5);
        pid_controller.setI(0);
        pid_controller.setD(0);
        pid_controller.setOutputRange(-1, 1);

        return pid_controller;
    }

    /**
     * Use this method to define your button->command mappings.  Buttons can be created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
     * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
        // Create some buttons
        final JoystickButton rightBumper = new JoystickButton(xboxController, XboxController.Button.kRightBumper.value);        
        rightBumper.whileHeld(new Shoot(m_shooter), true);

        final JoystickButton buttonA = new JoystickButton(xboxController, XboxController.Button.kA.value);        
        buttonA.toggleWhenPressed(new Intake(m_collection), true);

        final JoystickButton backButton = new JoystickButton(xboxController, XboxController.Button.kBack.value);        
        backButton.whileHeld(new RetractHanger(m_hanger), false);

        final JoystickButton startButton = new JoystickButton(xboxController, XboxController.Button.kStart.value);        
        startButton.whileHeld(new ExtendHanger(m_hanger), true);

        final JoystickButton leftBumper = new JoystickButton(xboxController, XboxController.Button.kLeftBumper.value);        
        leftBumper.whenPressed(new DriveToggle(m_drivetrain), true); 
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public XboxController getXboxController() {
        return xboxController;
    }
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
    // The selected command will be run in autonomous
        return m_chooser.getSelected();
    }
}
