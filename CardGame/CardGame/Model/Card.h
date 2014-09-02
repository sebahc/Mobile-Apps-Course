//
//  Card.h
//  CardGame
//
//  Created by sebahc on 9/2/14.
//  Copyright (c) 2014 Sebastian J Herrera Cano. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface Card : NSObject

@property(strong,nonatomic) NSString *contents;

@property(nonatomic,getter = isChosen) BOOL chosen;
@property(nonatomic,getter = isMatched) BOOL matched;

- (int) match:(Card *)card;

@end
