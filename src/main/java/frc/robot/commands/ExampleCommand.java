/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.controllers.ControllerSet;
import frc.robot.controllers.ControllerModel.AxisDef;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An example command that uses an example subsystem.
 */
public class ExampleCommand extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    private final ExampleSubsystem subsystem;
    private final ControllerSet controller;

    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
    public ExampleCommand(ExampleSubsystem subsystem, ControllerSet controller) {
        this.subsystem = subsystem;
        this.controller = controller;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(subsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {

    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {

        System.out.print("0: " + Math.round(controller.getRawAxis(new AxisDef(0, 0)) * 100) + "  ");
        System.out.print("1: " + Math.round(controller.getRawAxis(new AxisDef(0, 1)) * 100) + "  ");
        System.out.print("2: " + Math.round(controller.getRawAxis(new AxisDef(0, 2)) * 100) + "  ");
        System.out.print("3: " + Math.round(controller.getRawAxis(new AxisDef(0, 3)) * 100) + "  ");
        System.out.print("4: " + Math.round(controller.getRawAxis(new AxisDef(0, 4)) * 100) + "  ");
        System.out.println("5: " + Math.round(controller.getRawAxis(new AxisDef(0, 5)) * 100));
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        // out0.set(false);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
