//
//  main.m
//  DemoMatchismo
//
//  Created by sebahc on 9/2/14.
//  Copyright (c) 2014 Sebastian J Herrera Cano. All rights reserved.
//

#import <UIKit/UIKit.h>

#import "CardGameAppDelegate.h"
#import "CardMatchingGame.h"
#import "PlayingCardDeck.h"

int main(int argc, char * argv[])
{
    @autoreleasepool {
        return UIApplicationMain(argc, argv, nil, NSStringFromClass([CardGameAppDelegate class]));
        
      /*  CardMatchingGame *game = [[CardMatchingGame alloc] initWithCardCount:12 usignDeck:[[PlayingCardDeck alloc] init]];
        [game chooseCardAtIndex:6];
        
        NSLog(@"Puntaje: %d",game.score);*/
        
        
        
    }
}
