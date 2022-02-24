// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class TurnTo90 extends CommandBase {
  double powerAt90 = 0.5;
  double targetAngle = 90;
  double kP = powerAt90 / targetAngle;
  Drivetrain drivetrain;

  
  /** Creates a new TurnTo90. */
  public TurnTo90(Drivetrain drivetrain) {

    this.drivetrain = drivetrain;
    addRequirements(drivetrain);
    
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    
    double currentAngle = drivetrain.ahrs.getAngle();

    double error = targetAngle - currentAngle;
    double power = error * kP;
    drivetrain.setMotors(power,-power);


  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
