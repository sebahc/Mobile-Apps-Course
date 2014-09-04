//
//  main.m
//  CardGame
//
//  Created by sebahc on 9/2/14.
//  Copyright (c) 2014 Sebastian J Herrera Cano. All rights reserved.
//

#import <UIKit/UIKit.h>

#import "CardGameAppDelegate.h"
#import "Card.h"

int main(int argc, char * argv[])
{
    @autoreleasepool {
        return UIApplicationMain(argc, argv, nil, NSStringFromClass([CardGameAppDelegate class]));
        
        /*Card *myCard = [[Card alloc]init];
        
        myCard.contents=@"4Trebol";
        
        Card *otherCard = [[Card alloc]init];
        
        otherCard.contents=@"4Trebol";
        
        int resultado = [myCard match:otherCard];
        
        if (resultado==1) {
            NSLog(@"Las cartas son iguales");
            
        } else{
            NSLog(@"Las cartas son diferentes");
        }*/
        
    }
}
