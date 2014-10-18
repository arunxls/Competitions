#!/usr/bin/env perl
use strict;
use warnings FATAL => "all";

# use English "-no_match_vars";
use Data::Dumper;

print __PACKAGE__;
test::func();

package test;
use English "-no_match_vars";
use Data::Dumper;

print Dumper "foo";

sub func {
    print "HERE\n";
    # open (my $fh, "<", "absent") or die "$!";
    open (my $fh, "<", "absent") or die "$OS_ERROR";
    close $fh;
}

1;
