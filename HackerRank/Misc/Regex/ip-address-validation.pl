#!/usr/bin/perl
use strict;
use warnings;

sub match
{
    my $str = shift;
    my $return = 'Neither';

    if($str =~ /(.+:){7}.+/s) {
        $return = 'IPv6' if(_ipv6_validate(split(/:/,$str,8)));
    } elsif($str =~ /(.+\.){3}.+/s) {
        $return = 'IPv4' if(_ipv4_validate(split(/\./,$str)));
    }

    return $return

}

sub _ipv6_validate{
    my @num = @_;

    foreach my $i (@num){
        foreach my $j (split(//,$i)){
            if($j =~ /[0-9|a-f|A-F]+/s){
                next;
            } else {
                return 0;
            }
        }
    }
    return 1;
}

sub _ipv4_validate{
    my @num = @_;

    foreach my $i (@num){
        return 0 if(! (($i >= 0) && ($i <= 255)));
    }
    return 1;
}

# Tail starts here
my $testcases = <>;
for (1..$testcases){
    my $str = <>;
    chomp($str);
    print match($str)."\n";
}