.DEFAULT_GOAL := all

MAIN_FILES := $(wildcard ./src/*.ts)

package.json:

node_modules: package.json
	yarn install

.PHONY: $(MAIN_FILES)
$(MAIN_FILES): node_modules
	yarn ts-node $@

all: $(MAIN_FILES)
