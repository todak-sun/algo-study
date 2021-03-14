Array.prototype.reduce = function (func, initValue) {
  // 1.
  var _this = this;
  if (arguments.length === 1) {
    // 2.
    initValue = _this[0];
    _this = _this.slice(1);
  }
  for (var i = 0; i < _this.length; i++) {
    initValue = func(initValue, _this[i], i); // 3.
  }
  return initValue; // 4.
};

function stringifyStyle(style) {
  return Object.entries(style).reduce(
    (inline, [key, value]) => (inline += `${camelToPascal(key)}:${value}; `),
    ""
  );
}

function append(children, elem) {
  return wrapToArray(children).reduce((elem, child) => {
    elem.appendChild(child);
    return elem;
  }, elem);
}

function wrapToArray(item) {
  return Array.isArray(item) ? item : [item];
}

function create(name, attributes = {}) {
  return attr(attributes, document.createElement(name));
}

function attr(attrs, elem) {
  return Object.entries(attrs).reduce((elem, [key, value], i) => {
    const _key = camelToPascal(key);
    if (Array.isArray(value)) {
      elem.setAttribute(_key, value.join(" "));
    } else if (typeof value === "object") {
      elem.setAttribute(_key, stringifyStyle(value));
    } else {
      elem.setAttribute(_key, value);
    }
    return elem;
  }, elem);
}

function camelToPascal(str) {
  return str.replace(/[A-Z]/g, (s) => `-${s.toLowerCase()}`);
}

function _groupBy(arr, func) {
  return arr.reduce(function (group, item, index) {
    group[func(item)] = group[func(item)] ? group[func(item)] : [];
    group[func(item)].push(item);
    return group;
  }, {});
}
